package bot;

import command.TelegramBotCommand;
import method.GetUpdates;
import method.SendMessage;
import method.SendPhoto;
import method.TelegramBotMethod;
import object.Message;
import utility.MessageListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shafiq on 29/01/16.
 */
public abstract class TelegramBot {
    private List<TelegramBotCommand> commandList;
    private String name;

    public TelegramBot(String name){
        this.name = name;
        commandList = new ArrayList<TelegramBotCommand>();
    }

    public void addCommand(TelegramBotCommand command){
        commandList.add(command);
    }

    private static void init(){

    }

    public abstract void run();
}
