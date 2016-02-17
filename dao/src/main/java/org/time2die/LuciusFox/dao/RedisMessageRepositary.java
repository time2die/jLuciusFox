package org.time2die.LuciusFox.dao;

import org.time2die.LuciusFox.tg.common.tgConfiguration;
import redis.clients.jedis.Jedis;

/**
 * Created by time2die on 12.02.16.
 */
public class RedisMessageRepositary implements MessageRepository {

    public int saveRawMessage(String text , tgConfiguration configuration) {

        int textNumber = configuration.getUpdateMessageWriteIter() ;
        Jedis connection = tgJeredisPool.getInstance().getConnection() ;
        connection.set("tg.dao.message.raw."+textNumber, text) ;
        return 0 ;
    }

    @Override
    public int saveRawMessage(String text) {
        return 0;
    }
}
