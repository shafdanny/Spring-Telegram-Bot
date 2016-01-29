package method;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


/**
 * Created by shafiq on 29/01/16.
 */
public class SendMessage extends TelegramBotMethod{
    public SendMessage(String endpoint) {
        super(endpoint);
    }

    @Override
    public void executeMethod(String... args) throws RuntimeException {
        String chat_id = "53921753";
        String text = args[0];

        URI targetUrl = UriComponentsBuilder.fromUriString(getFullUrl())
                .queryParam("chat_id", chat_id)
                .queryParam("text", text)
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(targetUrl, null, Object.class);
    }
}
