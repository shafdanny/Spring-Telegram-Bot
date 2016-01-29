package main;

import method.SendMessage;
import method.TelegramBotMethod;

/**
 * Created by shafiq on 29/01/16.
 */
public class Main {
    public static void main(String[] args){
        TelegramBotMethod sendMessage = new SendMessage("/sendMessage");
        sendMessage.executeMethod("Ini adalah cubaan");
    }
}
