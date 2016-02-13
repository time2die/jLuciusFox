package springcontex.org.time2die.test.pubsub;

import org.springframework.context.annotation.Bean;

/**
 * Created by time2die on 13.02.16.
 */

public interface Pub {

    void addSub(Sub sub) ;
    void removeSub(Sub sub) ;
    void startWork() ;
}

