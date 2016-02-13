package org.time2die.LuciusFox.tg.common;

import java.util.List;

/**
 * Created by time2die on 11.02.16.
 */
public class tgConfigurationRedisImpl implements tgConfiguration {
    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public String getUpdateFileIdKey() {
        return null;
    }

    @Override
    public String getUpdatesSubject() {
        return null;
    }

    @Override
    public int getUpdateMessageWriteIter() {
        return 0;
    }

    @Override
    public int getUpdateFileReadIter() {
        return 0;
    }

    @Override
    public List<String> getClientsForUpdate() {
        return null;
    }

    @Override
    public tgConfiguration getConfig() {
        return null;
    }


}
