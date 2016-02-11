import org.time2die.LuciusFox.tg.common.Job
import org.time2die.LuciusFox.tg.common.tgConfigurationDump
import org.time2die.LuciusFox.tg.common.tgService

import java.util.concurrent.atomic.AtomicInteger

/**
 *
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
class getNewMessageAndToFileSaveJob implements Job {

    getNewMessageAndToFileSaveJob() {
    }

    @Override
    void work() {
        def ids = tgConfigurationDump.getKey(tgConfigurationDump.clientsForUpdate) as List<String>;
        if(ids.empty){
            return ;
        }

        AtomicInteger fileId = tgConfigurationDump.getKey(tgConfigurationDump.fileID) ;
        String filePath = conf
        ids.each {
            def result = tgService.getUpdates(it)
            int newFile = fileId.incrementAndGet() ;
            File f = new File(filePath+newFile.toString());
            if(f.exists()){
                print "delete and create:"+ f.absolutePath+" "
                f.delete()
                f.createNewFile()
            }
            f << result ;
            println result.length()
        }
    }
}
