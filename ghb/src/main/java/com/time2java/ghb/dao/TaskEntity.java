package com.time2java.ghb.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by time2die on 12.03.16.
 */
@Data
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue
    Long id;

    String taskClass;
    Date startTime;
}
