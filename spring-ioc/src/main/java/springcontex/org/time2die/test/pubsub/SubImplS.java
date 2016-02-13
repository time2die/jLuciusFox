package springcontex.org.time2die.test.pubsub;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by time2die on 13.02.16.
 */
public class SubImplS implements Sub {

    Pub pub;


    @PostConstruct
    public void init() {
        pub.addSub(this);
    }

    @PreDestroy
    public void de() {
        pub.removeSub(this);
    }

    @Override
    public void getMessage(Object o) {
        System.out.println("two:" + o.toString());
    }
}