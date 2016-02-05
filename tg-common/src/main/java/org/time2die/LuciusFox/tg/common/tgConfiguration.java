package org.time2die.LuciusFox.tg.common;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 *         now code, tomorrow - redis
 */
public class tgConfiguration {
    public static String clientsForUpdate = "tg.update.ids";
    public static String fileID = "tg.update.currentId";
    public static String apiKey1 = "";

    private static Map<String, Object> props = new HashMap<>();
static {
        List<String> ids = new ArrayList<>();
        ids.add(apiKey1);
        props.put(clientsForUpdate, ids);
        props.put(fileID, new AtomicInteger(0));
    }

    static public Object getKey(String key){
        return props.get(key) ;
    }

}