package com.time2java.ghb.task;

import com.time2java.ghb.slak.GHBSlackService;
import org.springframework.stereotype.Component;

/**
 * Created by time2die on 13.03.16.
 */
@Component
public class SendStatisticTask extends AbstractTask {

    public SendStatisticTask(GHBSlackService slackService) {
        super(slackService);
    }

    @Override
    public void start() {
        slackService.sendStatistic();
    }
}


