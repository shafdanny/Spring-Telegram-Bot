package example;

import bot.TelegramBot;
import command.TelegramBotCommand;
import object.Message;

/**
 * Created by shafiq on 30/01/16.
 *
 * Example of bot that send photo according to a defined command.
 */
public class PhotoBot extends TelegramBot {

    @Override
    public void newMessageReceived(Message message) {
        executeCommand(message);
    }

    @Override
    public void initCommandList() {
        addCommand(new TelegramBotCommand("/photo1") {
            @Override
            public void run(Message message) {
                String sender = Integer.toString(message.getFrom().getId());
                sendPhoto(sender, "media/bot1.jpg");
            }
        });

        addCommand(new TelegramBotCommand("/photo2") {
            @Override
            public void run(Message message) {
                String sender = Integer.toString(message.getFrom().getId());
                sendPhoto(sender, "media/bot2.jpeg");
            }
        });
    }

    public static void main(String[] args){
        new PhotoBot();
    }
}
