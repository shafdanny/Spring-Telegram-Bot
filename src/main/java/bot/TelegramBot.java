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

    public TelegramBotCommand getCommand(String commandName){
        for(TelegramBotCommand command:commandList){
            if(command.getCommandName().equals(commandName))
                return command;
        }

        return null;
    }

    public abstract void initCommandList();

    public abstract void run();


}
