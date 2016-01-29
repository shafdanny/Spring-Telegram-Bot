package method;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by shafiq on 29/01/16.
 */
public class SendMessage extends TelegramBotMethod{
    public SendMessage(String endpoint) {
        super(endpoint);
    }

    @Override
    public <T> void executeMethod(T... args) throws RuntimeException {

        String urlString = buildUrl(args);

        URI fullRequestUrl = null;

        try {
            fullRequestUrl = new URI(urlString);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(fullRequestUrl, null, Object.class);
    }

    @Override
    public <T> String buildUrl(T... args) {

        String chat_id = (String) args[0];
        String text = (String) args[1];

        URI targetUrl;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(getFullUrl())
                .queryParam("chat_id", chat_id)
                .queryParam("text", text);

        String parse_mode;

        try{
            parse_mode = (String) args[2];
            uriComponentsBuilder.queryParam("parse_mode", parse_mode);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        targetUrl = uriComponentsBuilder.build().toUri();

        return targetUrl.toString();
    }
}
