package com.time2die.autotask;

import com.time2die.autotask.dao.SlackApiKey;
import com.time2die.autotask.dao.repo.SlackApiKeyRepo;
import com.time2die.autotask.slack.SlackService;
import lombok.extern.log4j.Log4j;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */

@SpringBootApplication
@Log4j
@Configuration
public class JMain {
    public static void main(String[] args) {
        SpringApplication.run(JMain.class);
    }


    @Bean
    public CommandLineRunner demo(SlackApiKeyRepo slackApiKeyRepo) {
        return (args) -> {
            if (slackApiKeyRepo.findAll().isEmpty()) {
                SlackApiKey init = new SlackApiKey();
                init.setKey("xoxb-28589750389-szpZfPk2iZ4TQEwiUPWhVpJA");
                slackApiKeyRepo.save(init);
            }
        };
    }

    @PostConstruct
    public  void i() throws AxisFault, IllegalAccessException, InstantiationException {
        com.time2die.autotask.ATWSStub stub = new com.time2die.autotask.ATWSStub();
        com.time2die.autotask.ATWSStub.GetWsdlVersion getWsdlVersion129 = (com.time2die.autotask.ATWSStub.GetWsdlVersion) com.time2die.autotask.ATWSStub.GetWsdlVersion.class.newInstance();

    }

    @Bean
    public SlackService slackService(SlackApiKeyRepo slackApiKeyRepo, CommandLineRunner demo) {
        SlackService returnValue = new SlackService();
        returnValue.setSlackApiKeyRepo(slackApiKeyRepo);
        return returnValue;
    }
}