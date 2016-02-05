import org.time2die.LuciusFox.tg.common.Job;

/**
 *
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
class gMain {
    public static void main(String[] args) {
        Job nmj = new getNewMessageJob()

        (1..10).each {
            println("i:"+ it)
            nmj.work()
            Thread.sleep(100)
        }
    }
}
