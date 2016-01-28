package org.time2die.LuciusFox.tg.Sender;

import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
public class SenderTestImpl implements tgSender {

    String apiUrl = "https://api.telegram.org//bot";
    String apiKey = "168867787:AAFlmoROO6Sw52ueFaQMaeiirZL5CJLxNEQ";
    String method = "sendMessage";
    String testId = "69711013";
    String url = apiUrl + apiKey + "//" + method + '?'+ "chat_id="+ testId+ "&text=" ;

    @Override
    public void sendText(String id, String text) {
        System.out.println(url+text);
        GetMethod get = new GetMethod(url+text);
        try {
            InputStream in = get.getResponseBodyAsStream();
            if(in != null) {
                Scanner sc = new Scanner(in);
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        get.releaseConnection();
    }

// https://api.telegram.org/bot168867787:AAFlmoROO6Sw52ueFaQMaeiirZL5CJLxNEQ/sendMessage?chat_id=69711013&text=
}