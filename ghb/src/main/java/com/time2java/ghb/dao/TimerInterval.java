package com.time2java.ghb.dao;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

/**
 * Created by time2die on 07.03.16.
 */

@Data
@Entity
public class TimerInterval {

    public TimerInterval() {}

    public TimerInterval(Date startTime, Long interval) {
        this.startTime = startTime;
        this.interval = interval;
    }

    public TimerInterval(Date startTime) {
        this(startTime, 1000L * 60 * 45);
    }

    @Id
    @GeneratedValue
    Long id;
    Date startTime;
    long answerTime;
    long interval;
    String goal;

    public void setGoal(String goal) {
        this.goal = goal;
    }
}

