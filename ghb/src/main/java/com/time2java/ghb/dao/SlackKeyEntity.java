package com.time2java.ghb.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by time2die on 13.03.16.
 */
@Data
@Entity
public class SlackKeyEntity {
    private static final Logger LOGGER = Logger.getLogger(SlackKeyEntity.class);

    @Id
    @GeneratedValue
    Long id;

    String key;
}