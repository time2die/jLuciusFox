package org.time2die.LuciusFox.tg.common;


/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
public class UrlBuilder {

    static String apiUrl = "https://api.telegram.org/";
    static String testId = "69711013";


    public static String createSendMessage(String adress, String textMessage, String apiKey) {
        return apiUrl + apiKey + "/" + "sendMessage" + '?' + "chat_id=" + testId + "&text=" + textMessage;
//        return apiUrl + apiKey + "/" + "sendMessage" + '?' + "chat_id=" + adress+ "&text=" +textMessage;
    }

    public static String getUpdates(String apiKey) {
        return apiUrl + apiKey + "/" + "getUpdates";
    }

}