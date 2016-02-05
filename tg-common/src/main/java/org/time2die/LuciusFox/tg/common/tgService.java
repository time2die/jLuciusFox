package org.time2die.LuciusFox.tg.common;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
public class tgService {

    private static InputStream doCall(String url) {
        try {
            URL myurl = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
            InputStream ins = con.getInputStream();
            return ins;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static StringBuilder doCallAndReadResult(String url) {
        InputStream ins = doCall(url);
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader in = new BufferedReader(isr);
        String inputLine;
        StringBuilder result = new StringBuilder();
        try {
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static void sendMessage(String adress, String text, String apiKey) {
        doCall(UrlBuilder.createSendMessage(adress, text, apiKey));
    }

    public static StringBuilder getUpdates(String apiKey) {
        return doCallAndReadResult(UrlBuilder.getUpdates(apiKey));
    }

}