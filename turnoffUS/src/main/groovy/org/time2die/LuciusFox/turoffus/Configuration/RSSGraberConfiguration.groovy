package org.time2die.LuciusFox.turoffus.Configuration

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.time2die.LuciusFox.turoffus.Interfaces.SiteCrawler
import org.time2die.LuciusFox.turoffus.implimintation.RssClawlerImpl

/**
 * Created by time2die on 17.02.16.
 */
@Configuration
class RSSGraberConfiguration extends MockConfiguration {


    @Override
    @Bean
    public SiteCrawler siteCrawler() {
        return  new RssClawlerImpl()
    }
}
