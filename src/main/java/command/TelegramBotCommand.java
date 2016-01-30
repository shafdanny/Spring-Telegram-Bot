package command;

import object.Message;

/**
 * Created by shafiq on 29/01/16.
 */
public abstract class TelegramBotCommand {
    String commandName = "";

    public TelegramBotCommand(String commandName) {
        this.commandName = commandName;
    }

    public abstract void run(Message message);

    public String getCommandName(){
        return  commandName;
    }
}
