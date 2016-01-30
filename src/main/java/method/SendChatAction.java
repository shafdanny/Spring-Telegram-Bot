package method;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shafiq on 30/01/16.
 */
public class SendChatAction extends TelegramBotMethod {
    public SendChatAction() {
        super("/sendChatAction");
    }

    @Override
    public <T> void execute(T... args) {
        String chat_id = (String) args[0];
        String action = (String) args[1];

        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("chat_id", chat_id);
        map.add("action", action);


        restTemplate.postForObject(getFullUrl(), map, Object.class);
    }
}
