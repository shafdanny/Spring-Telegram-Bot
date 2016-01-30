package bot;

import command.TelegramBotCommand;
import method.*;
import object.Message;
import utility.MessageListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shafiq on 29/01/16.
 */
public abstract class TelegramBot {

    private List<TelegramBotCommand> commandList;

    // All the method that can be used for the communication with Telegram server
    private GetUpdates getUpdates = new GetUpdates();
    private SendMessage sendMessage = new SendMessage();
    private SendPhoto sendPhoto = new SendPhoto();
    private SendAudio sendAudio = new SendAudio();
    private SendChatAction sendChatAction = new SendChatAction();

    public TelegramBot(){
        commandList = new ArrayList<TelegramBotCommand>();
        initCommandList();
        getUpdates.addNewMessageListener(new MessageListener() {
            public void onNewMessageEvent(Message message) {
                newMessageReceived(message);
            }
        });
        getUpdates.execute();

    }

    public abstract void newMessageReceived(Message message);

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

    public void sendMessage(String receiver, String message){
        sendMessage.execute(receiver, message);
    }

    public void sendAudio(String sender_id, String filePath){
        sendAudio.execute(sender_id, filePath);
    }

    public void sendPhoto(String sender_id, String filePath){
        sendPhoto.execute(sender_id,filePath);
    }

    public void sendChatAction(String sender_id, String action) { sendChatAction.execute(sender_id,action);}

    public abstract void initCommandList();

    public void executeCommand(Message message){
        if(getCommand(message.getText()) != null){
            getCommand(message.getText()).run(message);
        }
        else {
            sendMessage(Integer.toString(message.getFrom().getId()),  "Unknown command");
        }
    }


}
