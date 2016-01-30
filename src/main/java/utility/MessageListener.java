package utility;

import object.Message;

import java.util.EventListener;

/**
 * Created by shafiq on 29/01/16.
 */
public interface MessageListener {
    void onNewMessageEvent(Message message);
}
