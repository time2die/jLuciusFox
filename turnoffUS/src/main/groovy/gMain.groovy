import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.time2die.LuciusFox.turoffus.Configuration.RSSGraberConfiguration
import org.time2die.LuciusFox.turoffus.Interfaces.Worker

class gMain {

    public static void main(String[] args) {
        ApplicationContext contex = new AnnotationConfigApplicationContext(RSSGraberConfiguration.class)
        Worker w = contex.getBean(Worker.class)
        w.work()
    }
}



