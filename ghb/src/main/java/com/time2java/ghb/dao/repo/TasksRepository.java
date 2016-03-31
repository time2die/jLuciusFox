package com.time2java.ghb.dao.repo;

import com.time2java.ghb.dao.answer.TaskAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by time2die on 12.03.16.
 */
public interface TasksRepository extends JpaRepository<TaskAnswer,Long> {
}
