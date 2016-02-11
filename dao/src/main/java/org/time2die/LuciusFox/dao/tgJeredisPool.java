package org.time2die.LuciusFox.dao;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by time2die on 12.02.16.
 */
public class tgJeredisPool {
    private static tgJeredisPool ourInstance = new tgJeredisPool();

    private JedisPool pool = new JedisPool();

    public static tgJeredisPool getInstance() {
        return ourInstance;
    }

    private tgJeredisPool() {
    }

    public Jedis getConnection(){
        return pool.getResource() ;
    }


}
