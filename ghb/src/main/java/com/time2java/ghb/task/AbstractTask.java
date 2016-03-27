package com.time2java.ghb.task;

import com.time2java.ghb.slak.GHBSlackService;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by time2die on 13.03.16.
 */
public abstract class AbstractTask implements ITask {
    @Setter
    @Getter
    protected GHBSlackService slackService;

    public AbstractTask(GHBSlackService slackService){
        this.slackService = slackService ;
    }

    @Override
    public  abstract void start()  ;


    @Override
    public void run() {
        start();
    }
}
