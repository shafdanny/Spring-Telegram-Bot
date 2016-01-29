package main;

import bot.TelegramBot;
import method.GetUpdates;
import method.SendMessage;
import method.SendPhoto;
import method.TelegramBotMethod;
import object.Message;
import utility.MessageListener;

/**
 * Created by shafiq on 29/01/16.
 */
public class Main {

    public static void main(String[] args){
        TestBot testBot = new TestBot("TestBot");
        testBot.run();
    }


}
