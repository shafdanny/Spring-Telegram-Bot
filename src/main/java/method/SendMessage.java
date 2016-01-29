package method;

import com.sun.xml.internal.xsom.impl.util.Uri;
import object.Update;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by shafiq on 29/01/16.
 */
public class SendMessage {
    public static void main(String[] args){
        String url = "https://api.telegram.org/bot187744061:AAEuMsPg9J3TElLGam2bvHx8YTat344maqU/sendMessage";

        String chat_id = "53921753";
        String text = "This is a test message";

        URI targetUrl = UriComponentsBuilder.fromUriString(url)
                        .queryParam("chat_id", chat_id)
                        .queryParam("text", text)
                        .build()
                        .toUri();

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(targetUrl, null, Object.class);

    }
}
