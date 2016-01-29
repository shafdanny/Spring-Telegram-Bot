package method;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * Created by shafiq on 29/01/16.
 */
public class SendMessage extends TelegramBotMethod{
    public SendMessage() {
        super("/sendMessage");
    }

    @Override
    public <T> void execute(T... args) throws RuntimeException {

        String chat_id = (String)args[0];
        String text = (String)args[1];

        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("chat_id", chat_id);
        map.add("text", text);

        try{
            String parse_mode = (String) args[2];
            map.add("parse_mode", parse_mode);
        }catch(Exception e){
            e.printStackTrace();
        }

        restTemplate.postForObject(getFullUrl(), map, Object.class);

    }
}
