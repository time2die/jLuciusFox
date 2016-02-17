package org.time2die.LuciusFox.tg.common;

import java.util.List;

/**
 * Created by time2die on 11.02.16.
 */
public interface tgConfiguration {
    public String get(String key);

    public String getUpdateFileIdKey() ;
    public String getUpdatesSubject() ;
    public int getUpdateMessageWriteIter() ;
    public int getUpdateFileReadIter() ;

    public List<String> getClientsForUpdate() ;

     tgConfiguration getConfig();

}
