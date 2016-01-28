package org.time2die.LuciusFox.dao;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
public interface MessageDao extends CrudRepository<RawMessage,Long> {
    List<RawMessage> findBytId(Long tId) ;
}