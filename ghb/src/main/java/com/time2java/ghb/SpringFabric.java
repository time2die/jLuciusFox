package com.time2java.ghb;

import com.time2java.ghb.dao.repo.GHBUserRepositary;
import com.time2java.ghb.dao.repo.KeyRepositary;
import com.time2java.ghb.dao.repo.TimeIntervalRepository;
import com.time2java.ghb.slak.GHBSlackService;
import com.time2java.ghb.task.AskGaolTask;
import com.time2java.ghb.task.ITask;
import com.time2java.ghb.task.SendStatisticTask;
import com.time2java.ghb.template.TemplateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by time2die on 14.03.16.
 */
@Configuration
public class SpringFabric {

    @Bean
    public GHBSlackService slackService(TimeIntervalRepository timeIntervalRepository, KeyRepositary keyRepositary,  GHBUserRepositary userRepositary) {
        return new GHBSlackService(timeIntervalRepository, keyRepositary, userRepositary);
    }

    @Bean
    public TemplateService templateService(){
        return new TemplateService() ;
    }

    @Bean
    public ITask askGaolTask(GHBSlackService slackService, TemplateService templateService) {
        return new AskGaolTask(slackService, templateService);
    }

    @Bean
    public ITask sendStatisticTask(GHBSlackService slackService) {
        return new SendStatisticTask((slackService));
    }

}
