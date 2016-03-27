package com.time2java.ghb.init

import com.time2java.ghb.dao.SlackKeyEntity
import com.time2java.ghb.dao.repo.KeyRepositary
import com.time2java.ghb.task.AskGaolTask
import com.time2java.ghb.task.ScheduledTask
import com.time2java.ghb.task.SendStatisticTask
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.Scheduled

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/**
 * Created by time2die on 17.03.16.
 */

@Configuration
@Profile("test")
class TestInit {

    private static final Logger log = LoggerFactory.getLogger(TestInit.class);

    TestInit(ApplicationContext context, KeyRepositary keyRepositary) {
        this.context = context
        this.keyRepositary = keyRepositary
    }

    KeyRepositary keyRepositary
    ApplicationContext context = null
    Calendar lastStartSchedulerTime = null
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    @Scheduled(fixedRate = 1000l)
    public void initSchedulerIfNeed() {
        try {
            if (lastStartSchedulerTime == null) {
                lastStartSchedulerTime = Calendar.getInstance()
                initExecutor()
                initKey(keyRepositary)
                return
            }

            if (lastStartSchedulerTime.get(Calendar.DAY_OF_MONTH) == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
                return
            }

            log.error("shutdown")
            executorService.shutdownNow()
            initExecutor()

        } catch (Exception e) {
            log.error(e);
        }
    }


    protected static void initKey(KeyRepositary keyRepositary) {
        if (keyRepositary.findAll().isEmpty()) {
            SlackKeyEntity key = new SlackKeyEntity();

            key.setKey("xoxb-25601707938-1akUzZRGiro14MAhAhAaAmYZ");
            keyRepositary.save(key);
        }
    }


    protected void initExecutor() {
        log.error("add new tasks")
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR)
        int m = c.get(Calendar.MINUTE)

        executorService.schedule(new ScheduledTask(context, AskGaolTask.class), getDelayToInSecond(h, m + 1),
                TimeUnit.SECONDS);
        executorService.schedule(new ScheduledTask(context, AskGaolTask.class), getDelayToInSecond(h, m + 2),
                TimeUnit.SECONDS);
        executorService.schedule(new ScheduledTask(context, SendStatisticTask.class), getDelayToInSecond
                (h, m + 6), TimeUnit.SECONDS);
    }


    protected long getDelayToInSecond(int h, int m) {
        Calendar future = Calendar.getInstance()
        future.set(Calendar.HOUR, h)
        future.set(Calendar.MINUTE, m)

        long delay = future.timeInMillis - Calendar.getInstance().timeInMillis;
        delay = delay > 0 ? delay / 1000 : 60 * 60 * 24;
        log.error("add task for:" + delay + "seconds")
        return delay
    }

}
