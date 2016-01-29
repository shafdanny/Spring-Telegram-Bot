package main;

import method.GetUpdates;
import method.SendMessage;
import method.TelegramBotMethod;
import object.Message;
import utility.MessageListener;

/**
 * Created by shafiq on 29/01/16.
 */
public class Main {
    public static void main(String[] args){
        String testReceiverId = "53921753";

        TelegramBotMethod sendMessage = new SendMessage("/sendMessage");

        GetUpdates getUpdates = new GetUpdates("/getUpdates");

        getUpdates.addNewMessageListener(new MessageListener() {
            @Override
            public void newMessage(Message message) {
                System.out.println("MESSAGE RECEIVED: " + message.getText());
                sendMessage.executeMethod(testReceiverId, "ECHO: " + message.getText());
            }
        });
        getUpdates.executeMethod();
    }
}
