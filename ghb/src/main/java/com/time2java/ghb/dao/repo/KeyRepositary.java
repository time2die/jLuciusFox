package com.time2java.ghb.dao.repo;

import com.time2java.ghb.dao.SlackKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
public interface KeyRepositary extends JpaRepository<SlackKeyEntity, Long> {
}
