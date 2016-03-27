package com.time2java.ghb.slak

import com.time2java.ghb.dao.*
import com.time2java.ghb.dao.repo.GHBUserRepositary
import com.time2java.ghb.dao.repo.KeyRepositary
import com.time2java.ghb.dao.repo.TimeIntervalRepository
import com.ullink.slack.simpleslackapi.SlackSession
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory
import com.ullink.slack.simpleslackapi.listeners.SlackMessagePostedListener
import lombok.extern.java.Log
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.stevew.SlackClient
import org.stevew.model.channel.Channel

import javax.annotation.PostConstruct
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by time2die on 13.03.16.
 */
@Configuration
class GHBSlackService {

    private static final Logger log = LoggerFactory.getLogger(GHBSlackService.class);

    private TimeIntervalRepository timeIntervalRepository
    private KeyRepositary keyRepositary
    private GHBUserRepositary userRepositary


    public GHBSlackService(TimeIntervalRepository timeIntervalRepository, KeyRepositary keyRepositary, GHBUserRepositary userRepositary) {
        this.timeIntervalRepository = timeIntervalRepository
        this.keyRepositary = keyRepositary
        this.userRepositary = userRepositary
    }

    public void sendStatistic() {
        for (SlackKeyEntity key : keyRepositary.findAll()) {
            SlackClient slackClient = new SlackClient(key.key)

            String statisticText = prepareStatistic(slackClient);

            Channel ch = slackClient.getChannelByName("ghb_statistic")
            sendMessage(key.key, statisticText, ch.id)
        }
    }

    String prepareStatistic(SlackClient slackClient) {
        StringBuffer statistic = new StringBuffer()
        statistic.append("Friday statistic:\n")
        slackClient.userList.each {
            if (!it.isBot) {
                GHBUser iterUser = getOrCreateUserBySlackId(it.id, it.name)
                statistic.append("user " + iterUser.username)

                Set<String> goals = new HashSet<>()
                iterUser.timers.each {
                    goals.add(it.goal)
                }

                if (goals.empty) {
                    statistic.append(" no informations")
                } else {
                    statistic.append(" goals:\n")
                }
                goals.each {
                    List<TimerInterval> intervals = timeIntervalRepository.getByGoal(it)
                    int sum = 0;
                    intervals.each { TimerInterval interval ->
                        sum += interval.interval
                    }
                    sum = sum / 1000 / 60
                    statistic.append("\'$it\' : $sum minute ")
                    statistic.append("\n")
                }
                statistic.append("\n")
            }
        }
        statistic.append("\n")
        return statistic.toString()
    }

    public void askAll(String message) {
        try {
            for (SlackKeyEntity key : keyRepositary.findAll()) {
                SlackClient slackClient = new SlackClient(key.key)
                log.error("userList:" + slackClient.userList.toString())
                slackClient.userList.each {

                    if (!it.isBot) {
                        loginIntervalmap.put(it.id, new TimerInterval(Calendar.instance.time))
                        log.error("put:" + it.id)
                        log.error("send to:$it.id:$it.name")
                        sendMessage(key.key, message, it.id)
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.toString())
        }
    }


    private void sendMessage(String key, String message, String chanelId) {
        try {
            SlackClient slackClient = new SlackClient(key)
            slackClient.sendMessage(message, chanelId, "ghb", "", true)
        } catch (Exception e) {
            log.error(e.toString())
        }
    }

    @PostConstruct
    public void readMessage() {
        final SlackSession session = SlackSessionFactory.createWebSocketSlackSession("xoxb-25601707938-1akUzZRGiro14MAhAhAaAmYZ")
        log.error("start listening")
        session.addMessagePostedListener(new SlackMessagePostedListener() {
            @Override
            public void onEvent(SlackMessagePosted event, SlackSession session1) {
                log.error("get message:" + event.messageContent)
                log.error("from: " + event.sender.id + "\tisBot:" + event.sender.bot)
                log.error("map:" + loginIntervalmap.toString())

                if (event.sender.bot)
                    return

                String senderId = event.sender.id
                try {
                    TimerInterval timerInterval = loginIntervalmap.get(senderId)
                    if (timerInterval == null) {
                        log.error("can't read id:" + loginIntervalmap.get(senderId))
                        return
                    }

                    GHBUser senderUser = getOrCreateUser(event);
                    timerInterval.setGoal(event.messageContent)
                    senderUser.timers.add(timerInterval)
                    userRepositary.save(senderUser)

                    log.error("save:" + timerInterval.toString())
                    loginIntervalmap.put(senderId, null)
                } catch (Exception e) {
                    e.printStackTrace()
                    log.error(e.toString())
                    log.error(e.stackTrace.toString())

                }
            }
        });
        session.connect();
    }

    private HashMap<String, TimerInterval> loginIntervalmap = new ConcurrentHashMap<>();

    private GHBUser getOrCreateUser(SlackMessagePosted event) {
        return getOrCreateUserBySlackId(event.sender.id, event.sender.userName)

    }

    private GHBUser getOrCreateUserBySlackId(String slackId, String userName) {
        List<GHBUser> users = userRepositary.getBySlackId(slackId)
        GHBUser result = null;

        if (!users.empty)
            result = users.first()

        if (result == null) {
            users = userRepositary.getByUsername(userName)
            if (!users.empty)
                result = users.first()
        }

        if (result == null)
            result = new GHBUser()

        if (result.username == null)
            result.username = userName

        if (result.slackId == null)
            result.slackId = slackId

        if (result.timers == null)
            result.timers = new ArrayList<TimerInterval>()

        return result
    }

}
