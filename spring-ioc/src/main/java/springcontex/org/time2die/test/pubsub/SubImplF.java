package springcontex.org.time2die.test.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * Created by time2die on 13.02.16.
 */
@Component
public class SubImplF implements Sub {

    @Autowired
    public Pub pub ;

    public Pub getPub() {
        return pub;
    }

    public void setPub(Pub pub) {
        this.pub = pub;
    }

    public SubImplF() {

    }

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
        System.out.println("one:" + o.toString());
    }
}
