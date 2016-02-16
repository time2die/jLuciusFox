package org.time2die.LuciusFox.turoffus.implimintation

import org.springframework.stereotype.Component
import org.time2die.LuciusFox.turoffus.Interfaces.SiteCrawler
import org.time2die.LuciusFox.turoffus.entity.Update
import org.time2die.LuciusFox.tg.common.tgService

/**
 * Created by time2die on 17.02.16.
 */
@Component
class RssClawlerImpl implements SiteCrawler {



    @Override
    List<Update> getSiteUpdate(){
        List<Update> result = new ArrayList<>()
        def xmlBod = tgService.doCallAndReadResult("http://turnoff.us/feed.xml")
        println xmlBod

        return result
    }
}


