package org.time2die.LuciusFox.tg.Sender;


import org.eclipse.jetty.client.HttpClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
public class SenderTestImpl implements tgSender {

    static String apiUrl = "https://api.telegram.org/bot";
    static String apiKey = "168867787:AAFlmoROO6Sw52ueFaQMaeiirZL5CJLxNEQ";
    static String method = "sendMessage";
    static String testId = "69711013";
    static String url = apiUrl + apiKey + "/" + method + '?' + "chat_id=" + testId + "&text=";

    @Override
    public void sendText(String id, String text) {
        h2(text);
    }


    static void h2(String text){
        BufferedReader in = null ;
        try {
            String httpsURL = url+text ;
            URL myurl = new URL(httpsURL);
            HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
            InputStream ins = con.getInputStream();
            InputStreamReader isr = new InputStreamReader(ins);
            in = new BufferedReader(isr);

            String inputLine;

            while ((inputLine = in.readLine()) != null)
            {
                System.out.println(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}