package com.time2java.ghb.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by time2die on 07.03.16.
 */
@Data
@Entity
public class GHBUser {

    public GHBUser(){}

    @Id
    @GeneratedValue
    Long id;

    String slackId;

    String username;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<TimerInterval> timers;



}
