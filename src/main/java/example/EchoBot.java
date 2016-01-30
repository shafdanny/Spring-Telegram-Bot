package example;

import bot.TelegramBot;
import method.GetUpdates;
import method.SendMessage;
import object.Message;
import utility.MessageListener;

/**
 * Created by shafiq on 30/01/16.
 *
 * An example bot that will echo the message sent to the bot (reply the user with the message that is sent).
 * There is no command associated with this bot.
 *
 */
public class EchoBot extends TelegramBot {
    public EchoBot(String name) {
        super(name);
    }

    @Override
    public void initCommandList() {

    }

    @Override
    public void run() {
        GetUpdates getUpdates = new GetUpdates();
        getUpdates.addNewMessageListener(new MessageListener() {
            @Override
            public void onNewMessageEvent(Message message) {
                String sender_id = Integer.toString(message.getChat().getId());
                new SendMessage().execute(sender_id, "ECHO: " + message.getText());
            }
        });
        getUpdates.execute();

    }
}
