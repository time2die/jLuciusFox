import org.time2die.LuciusFox.tg.common.Job
import org.time2die.LuciusFox.tg.common.tgConfiguration
import org.time2die.LuciusFox.tg.common.tgService

import java.util.concurrent.atomic.AtomicInteger

/**
 *
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
class getNewMessageJob implements Job {

    getNewMessageJob() {
    }

    @Override
    void work() {
        def ids = tgConfiguration.getKey(tgConfiguration.clientsForUpdate) as List<String>;
        if(ids.empty){
            return ;
        }

        AtomicInteger fileId = tgConfiguration.getKey(tgConfiguration.fileID) ;
        ids.each {
            def result = tgService.getUpdates(it)
            int newFile = fileId.incrementAndGet() ;
            File f = new File(newFile.toString());
            if(f.exists()){
                println "delete and create:"+ f.absolutePath
                f.delete()
                f.createNewFile()
            }
            f << result ;
        }
    }
}
