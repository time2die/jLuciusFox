package com.time2java.ghb.dao.repo;

import com.time2java.ghb.dao.GHBUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by time2die on 07.03.16.
 */
public interface GHBUserRepositary extends JpaRepository<GHBUser, Long> {
    List<GHBUser> getBySlackId(String slackId);
    List<GHBUser> getByUsername(String nickName);
}
