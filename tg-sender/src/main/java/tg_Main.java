import org.time2die.LuciusFox.tg.Sender.SenderTestImpl;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
public class tg_Main {

    public static void main(String [] args){
        SenderTestImpl sti = new SenderTestImpl() ;
        sti.sendText(null,"test");
        sti.sendText(null,"test1");
        sti.sendText(null,"test2");
    }
}