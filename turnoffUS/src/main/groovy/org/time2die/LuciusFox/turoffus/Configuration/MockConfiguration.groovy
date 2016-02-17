package org.time2die.LuciusFox.turoffus.Configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.time2die.LuciusFox.turoffus.Interfaces.Dao
import org.time2die.LuciusFox.turoffus.Interfaces.SiteCrawler
import org.time2die.LuciusFox.turoffus.Interfaces.UpdateSender
import org.time2die.LuciusFox.turoffus.Interfaces.Worker
import org.time2die.LuciusFox.turoffus.entity.Update

import javax.annotation.PostConstruct

/**
 * Created by time2die on 17.02.16.
 */
@Configuration
class MockConfiguration {
    @Bean
    Worker worker() {
        return new Worker() {
            @Autowired
            SiteCrawler siteCrawler

            @Autowired
            Dao dao

            @Autowired
            UpdateSender updater

            public void work() {
                Update lastNews = siteCrawler.siteUpdate.get(0)
                if (dao.lastNewHash.equals(lastNews)) {
                    return
                }


                dao.addUpdate(lastNews)
                updater.sendUpdate(lastNews)
            }
        }
    }

    @Bean
    public Dao dao() {
        return new Dao() {
            List<Update> updateList = new ArrayList<>()

            @Override
            int getLastNewHash() {
                if (updateList.empty) {
                    return 0;
                }
                updateList.last().hashCode()
            }

            @Override
            void addUpdate(Update update) {
                updateList.add(update)
            }
        }
    }

    @Bean
    public SiteCrawler siteCrawler() {
        return new SiteCrawler() {
            def news = [];

            @PostConstruct
            public init() {
                (1..100).each {
                    Update n = new Update()
                    n.link = it
                    news.add(n)
                }
            }

            @Override
            List<Update> getSiteUpdate() {
                return news
            }
        }
    }

    @Bean
    UpdateSender updateSender() {
        return new UpdateSender() {
            @Override
            void sendUpdate(Update update) {
                println "$update.title"
            }
        }
    }
}

