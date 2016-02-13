package springcontex.org.time2die.test.pubsub;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by time2die on 13.02.16.
 */

public class Worker {

    Pub pub ;

    Sub first ;

    Sub second ;


    public void workwork(){
        pub.addSub(first);
        pub.addSub(second);
        pub.startWork();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
