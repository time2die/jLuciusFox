package org.time2die.LuciusFox.turoffus.Interfaces

import org.time2die.LuciusFox.turoffus.entity.Update

/**
 * Created by time2die on 17.02.16.
 */

interface Dao {
    int getLastNewHash();

    void addUpdate(Update update)

}
