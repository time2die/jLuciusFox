import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import springcontex.SpringContex
import springcontex.org.time2die.test.pubsub.Worker

/**
 * Created by time2die on 13.02.16.
 */
class gMain {

    static public void main(String [] args){
        ApplicationContext contex = new AnnotationConfigApplicationContext(SpringContex.class)
        Worker worker = contex.getBean(Worker.class)
        worker.workwork()
    }
}
