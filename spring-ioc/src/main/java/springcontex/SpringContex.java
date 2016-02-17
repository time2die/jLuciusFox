package springcontex;
/**
 * Created by time2die on 13.02.16.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import springcontex.org.time2die.test.pubsub.*;

@Configuration
public class SpringContex {

    @Bean
    public Pub pub(){
        return new PubImpl() ;
    }

    @Bean
    Sub first(){
        return new SubImplF() ;
    }

    @Bean
    Sub second(){
        return new SubImplS() ;
    }

    @Bean
    Worker worker(){
        return new Worker() ;
    }

}
