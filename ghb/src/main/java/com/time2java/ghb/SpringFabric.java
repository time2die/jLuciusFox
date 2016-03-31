package com.time2java.ghb;

import com.time2java.ghb.dao.answer.repo.AnswerRepo;
import com.time2java.ghb.dao.answer.repo.HotAnswerRepo;
import com.time2java.ghb.dao.answer.repo.TaskAnswerRepo;
import com.time2java.ghb.dao.answer.repo.WorkingAnswerRepo;
import com.time2java.ghb.dao.repo.GHBUserRepositary;
import com.time2java.ghb.dao.repo.KeyRepository;
import com.time2java.ghb.dao.repo.SlackmessageRepository;
import com.time2java.ghb.slak.MessageProcessor;
import com.time2java.ghb.task.ScheduledTaskFabric;
import com.time2java.ghb.template.TemplateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by time2die on 14.03.16.
 */
@Configuration
public class SpringFabric {

    @Bean
    public AnswerRepo answerRepo(HotAnswerRepo hotAnswerRepo, TaskAnswerRepo taskAnswerRepo, WorkingAnswerRepo workingAnswerRepo) {
        return new AnswerRepo(hotAnswerRepo, taskAnswerRepo, workingAnswerRepo);
    }

    @Bean
    public ScheduledTaskFabric scheduledTaskFabric(MessageProcessor messageProcessor, TemplateService templateService) {
        return new ScheduledTaskFabric(messageProcessor, templateService);
    }

    @Bean
    public MessageProcessor messageProcessor(KeyRepository keyRepository, SlackmessageRepository slackmessageRepository, GHBUserRepositary ghbUserRepositary, AnswerRepo answerRepo) {
        return new MessageProcessor(keyRepository, slackmessageRepository, ghbUserRepositary, answerRepo);
    }

    @Bean
    public TemplateService templateService() {
        return new TemplateService();
    }

}
