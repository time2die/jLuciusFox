import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

class gMain {

    public static void main(String[] args) {
        ApplicationContext contex = new AnnotationConfigApplicationContext(TurnUsOffContextLocal.class)
        Worker w = contex.getBean(Worker.class)
        w.work()
    }
}

@Configuration
class TurnUsOffContextLocal {

    @Bean
    Worker worker() {
        return new Worker()
    }

    @Bean
    public Dao dao() {
        return new Dao() {
            List<Update> updateList = new ArrayList<>()

            @Override
            int getLastNewHash() {
                if(updateList.empty){
                    return 0 ;
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
            def news = [] ;
            @PostConstruct
            public init(){
                (1..100).each {
                    news.add(new Update("turnus.off/$it","pic$it",it))
                }
            }

            @Override
            Update getLastNews() {
                return news.get(new Random().nextInt(news.size()))
            }
        }
    }

    @Bean
    Updater update() {
        return new Updater() {
            @Override
            void sendUpdate(Update update) {
                println "$update.link:$update.content"
            }
        }
    }

}

@Component
class Worker {
    @Autowired
    SiteCrawler siteCrawler

    @Autowired
    Dao dao

    @Autowired
    Updater updater

    public void work() {
        Update lastNews = siteCrawler.lastNews
        if (dao.lastNewHash.equals(lastNews)) {
            return
        }


        dao.addUpdate(lastNews)
        updater.sendUpdate(lastNews)
    }

}

interface SiteCrawler {
    Update getLastNews()

}


interface Dao {
    int getLastNewHash();

    void addUpdate(Update update)
}

class Update {
    String link;
    String content;
    String id;

    Update(String link, String content, id) {
        this.link = link
        this.content = content
        this.id = id
    }
}

interface Updater {
    void sendUpdate(Update update)
}

