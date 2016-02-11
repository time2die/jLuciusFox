import org.time2die.LuciusFox.tg.common.Job
import org.time2die.LuciusFox.tg.common.tgConfiguration
import org.time2die.LuciusFox.tg.common.tgConfigurationDump
import org.time2die.LuciusFox.tg.common.tgService
import org.time2die.LuciusFox.tg.dao.*

import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by time2die on 11.02.16.
 */
class saveUpdatesToRedisJob implements Job {

    private tgConfiguration configuration
    private MessageRepository repository ;

    saveUpdatesToRedisJob(tgConfiguration configuration)
    {
        this.configuration = configuration ;
    }

    @Override
    void work() {
        def ids = configuration.getClientsForUpdate()
        if(ids.empty){
            return ;
        }

        AtomicInteger fileId = tgConfigurationDump.getKey(tgConfigurationDump.fileID) ;

        ids.each {
            def result = tgService.getUpdates(it)

        }

    }
}
