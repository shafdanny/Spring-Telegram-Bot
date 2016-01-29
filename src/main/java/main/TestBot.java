package main;

import bot.TelegramBot;
import method.SendMessage;
import method.TelegramBotMethod;

/**
 * Created by shafiq on 29/01/16.
 */
public class TestBot extends TelegramBot {
    public TestBot(String name) {
        super(name);
    }

    @Override
    public void run() {
        String testReceiverId = "53921753";

        TelegramBotMethod sendMessage = new SendMessage("/sendMessage");
        sendMessage.executeMethod(testReceiverId, "<b>Greetings !</b> from TestBot", "HTML");
    }
}
