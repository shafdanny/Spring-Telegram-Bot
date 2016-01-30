package command;

import object.Message;

/**
 * Created by shafiq on 29/01/16.
 *
 * Abstract class of TelegramBotCommand.
 *
 * This is for the command that we define to facilitate the communication with user.
 * Telegram stated that a command is a slash followed by a name (ex: /help , /info).
 * When a user send a command, the method run of the command will be executed.
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
