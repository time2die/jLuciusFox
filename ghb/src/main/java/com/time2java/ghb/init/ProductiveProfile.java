package com.time2java.ghb.init;

import com.time2java.ghb.dao.SlackKeyEntity;
import com.time2java.ghb.dao.answer.AreWorkingAnswer;
import com.time2java.ghb.dao.answer.HotAnswer;
import com.time2java.ghb.dao.answer.TaskAnswer;
import com.time2java.ghb.dao.repo.KeyRepository;
import com.time2java.ghb.task.ScheduledTaskFabric;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by time2die on 17.03.16.
 */
@Configuration
@Profile("productive")
public class ProductiveProfile extends AbstractInit {


    public ProductiveProfile(KeyRepository keyRepository, ScheduledTaskFabric scheduledTaskFabric) {
        super(keyRepository, scheduledTaskFabric);
    }

    protected void initKey(KeyRepository keyRepository) {
        keyRepository.deleteAll();

        SlackKeyEntity key = new SlackKeyEntity();
        key.setKey("xoxb-25601707938-1akUzZRGiro14MAhAhAaAmYZ");
        keyRepository.save(key);

        SlackKeyEntity markusKey = new SlackKeyEntity();
        markusKey.setKey("xoxb-28264610261-ixPRqgcQuBnRBbrzkqRpAAtJ");
        keyRepository.save(markusKey);
    }

    @Override
    protected void initExecutor() {
        addSchedule(12, 05, new HotAnswer());

        //12.15
        addSchedule(12, 10, new TaskAnswer(InitUtils.now()));
        addSchedule(12, 15, new AreWorkingAnswer());
        //12.45
        addSchedule(12, 40, new TaskAnswer(InitUtils.now()));
        addSchedule(12, 45, new AreWorkingAnswer());
        //13.15
        addSchedule(13, 10, new TaskAnswer(InitUtils.now()));
        addSchedule(13, 15, new AreWorkingAnswer());

        //13.45
        addSchedule(13, 40, new TaskAnswer(InitUtils.now()));
        addSchedule(13, 45, new AreWorkingAnswer());

        //14.30
        addSchedule(14, 25, new TaskAnswer(InitUtils.now()));
        addSchedule(14, 30, new AreWorkingAnswer());

        //15.00
        addSchedule(14, 55, new TaskAnswer(InitUtils.now()));
        addSchedule(15, 00, new AreWorkingAnswer());

        //15.30
        addSchedule(15, 25, new TaskAnswer(InitUtils.now()));
        addSchedule(15, 30, new AreWorkingAnswer());

        //17.00
        addSchedule(16, 55, new TaskAnswer(InitUtils.now()));
        addSchedule(16, 00, new AreWorkingAnswer());

        //17.30
        addSchedule(17, 25, new TaskAnswer(InitUtils.now()));
        addSchedule(17, 30, new AreWorkingAnswer());

        //18/00
        addSchedule(17, 55, new TaskAnswer(InitUtils.now()));
        addSchedule(18, 00, new AreWorkingAnswer());

        //18.30
        addSchedule(18, 25, new TaskAnswer(InitUtils.now()));
        addSchedule(18, 30, new AreWorkingAnswer());

        //19.00
        addSchedule(18, 55, new TaskAnswer(InitUtils.now()));
        addSchedule(19, 00, new AreWorkingAnswer());

        //19.30
        addSchedule(19, 25, new TaskAnswer(InitUtils.now()));
        addSchedule(19, 30, new AreWorkingAnswer());
    }
}
