package example;

import bot.TelegramBot;

import object.Message;


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
