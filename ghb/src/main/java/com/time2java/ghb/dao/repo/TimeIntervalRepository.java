package com.time2java.ghb.dao.repo;

import com.time2java.ghb.dao.TimerInterval;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by time2die on 07.03.16.
 */
public interface TimeIntervalRepository extends JpaRepository<TimerInterval, Long> {
    List<TimerInterval> getByInterval(long interval);
    List<TimerInterval> getByGoal(String Interval);

}
