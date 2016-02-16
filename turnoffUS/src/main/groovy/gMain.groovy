import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.time2die.LuciusFox.turoffus.Configuration.MockConfiguration
import org.time2die.LuciusFox.turoffus.Interfaces.Worker

import javax.annotation.PostConstruct

class gMain {

    public static void main(String[] args) {
        ApplicationContext contex = new AnnotationConfigApplicationContext(MockConfiguration.class)
        Worker w = contex.getBean(Worker.class)
        w.work()
    }
}



