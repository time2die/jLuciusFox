package com.time2java.ghb.task;

import lombok.Data;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * @author Aleksandr Karpov
 */
@Data
public class ScheduledTask implements Runnable {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    ScheduledTask(ApplicationContext context, Class taskClass) {
        this.context = context;
        this.taskClass = taskClass;
    }

    boolean needWork = true;
    Class taskClass;
    ApplicationContext context;

    @Override
    public void run() {
        try {
            if (!needWork) {
                return;
            }
            log.error("start:"+ taskClass);
            needWork = taskClass == SendStatisticTask.class;

            ITask task = (ITask) context.getBean(taskClass);
            task.start();

        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}

