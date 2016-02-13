package springcontex.org.time2die.test.pubsub;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by time2die on 13.02.16.
 */

public class Worker {

    Pub pub ;

    Sub first ;

    Sub second ;

    public Worker(Pub pub, Sub first, Sub second) {
        setPub(pub);
        setFirst(first);
        setSecond(second);
    }

    public Pub getPub() {
        return pub;
    }

    public void setPub(Pub pub) {
        this.pub = pub;
    }

    public Sub getFirst() {
        return first;
    }

    public void setFirst(Sub first) {
        this.first = first;
    }

    public Sub getSecond() {
        return second;
    }

    public void setSecond(Sub second) {
        this.second = second;
    }

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
