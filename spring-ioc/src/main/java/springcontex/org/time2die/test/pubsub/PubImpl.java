package springcontex.org.time2die.test.pubsub;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by time2die on 13.02.16.
 */
@Component
public class PubImpl implements Pub {
    Set<Sub> l = new HashSet<>();

    @Override
    public void addSub(Sub sub) {
        l.add(sub);
    }

    @Override
    public void removeSub(Sub sub) {
        l.remove(sub);
    }

    @Override
    public void startWork() {
        while (iter++ < 10) {
            try {
                Thread.sleep(1000);
                for (Sub s : l) {
                    s.getMessage(iter);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }

    }

    private int iter = 0;

}
