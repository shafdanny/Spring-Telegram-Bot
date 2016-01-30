package main;

import bot.TelegramBot;
import command.TelegramBotCommand;
import method.GetUpdates;
import method.SendMessage;
import method.SendPhoto;
import method.TelegramBotMethod;
import object.Message;
import utility.MessageListener;

/**
 * Created by shafiq on 29/01/16.
 */
public class TestBot extends TelegramBot {
    public TestBot(String name) {
        super(name);
        initCommandList();
    }

    @Override
    public void newMessageReceived(Message message) {

    }

    @Override
    public void initCommandList() {
        addCommand(new TelegramBotCommand("/help") {
            @Override
            public Object run(Message message) {
                TelegramBotMethod sendMessage = new SendMessage();
                String sender_id = Integer.toString(message.getFrom().getId());

                sendMessage.execute(sender_id, "<b>Help</b> you want ?", "HTML");
                return null;
            }
        });
    }

}
