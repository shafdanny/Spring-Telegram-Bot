package example;

import bot.TelegramBot;
import method.GetUpdates;
import method.SendMessage;
import object.Message;
import utility.MessageListener;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by shafiq on 30/01/16.
 *
 * An example bot that will echo the message sent to the bot (reply the user with the message that is sent).
 * There is no command associated with this bot.
 *
 */
public class EchoBot extends TelegramBot {

    @Override
    public void newMessageReceived(Message message) {
        String sender_id = Integer.toString(message.getChat().getId());
        sendMessage(sender_id, "ECHO: " + message.getText());
    }

    @Override
    public void initCommandList() {

    }

    public static void main(String[] args){
        new EchoBot();
    }

}
