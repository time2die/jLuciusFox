package com.time2java.ghb.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by time2die on 13.03.16.
 */
@Data
@Entity
public class SlackKeyEntity {

    @Id
    @GeneratedValue
    Long id;
    String key;
}