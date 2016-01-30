package method;

import object.Update;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import utility.MessageListener;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shafiq on 29/01/16.
 *
 * Get the updates from Telegram server.
 */
public class GetUpdates extends TelegramBotMethod{

    private int updateIdStart = 0;
    private static List<MessageListener> newMessageListeners = new ArrayList<MessageListener>();

    public static void addNewMessageListener(MessageListener listener){
        newMessageListeners.add(listener);
    }

    public GetUpdates() {
        super("/getUpdates");
    }

    @Override
    public <T> void execute(T... args) throws RuntimeException {

        while(true) {
            URI targetUrl = UriComponentsBuilder.fromUriString(getFullUrl())
                    .queryParam("offset", updateIdStart + 1)
                    .build()
                    .toUri();

            RestTemplate restTemplate = new RestTemplate();

            GetUpdatesResponse test = restTemplate.getForObject(targetUrl, GetUpdatesResponse.class);

            ArrayList<Update> updateList = (ArrayList<Update>) test.getResult();

            for (Update update : updateList) {
                // Action to run when a new message is received

                for(MessageListener listener:newMessageListeners){
                    listener.onNewMessageEvent(update.getMessage());
                }

                // Update the update_id so that we only request recent messages
                if(update.getUpdate_id()>updateIdStart)
                    updateIdStart = update.getUpdate_id();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
