package method;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.tools.packager.Log;

import object.Update;
import object.User;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shafiq on 29/01/16.
 */
public class GetUpdates {
    public static void main(String[] args){
        String url = "https://api.telegram.org/bot187744061:AAEuMsPg9J3TElLGam2bvHx8YTat344maqU/getUpdates";
        int updateIdStart = 883762352;


        while(true) {
            URI targetUrl = UriComponentsBuilder.fromUriString(url)
                    .queryParam("offset", updateIdStart + 1)
                    .build()
                    .toUri();

            RestTemplate restTemplate = new RestTemplate();
            GetUpdatesResponse test = restTemplate.getForObject(targetUrl, GetUpdatesResponse.class);

            ArrayList<Update> updateList = (ArrayList<Update>) test.getResult();

            for (Update update : updateList) {
                System.out.println(update.getMessage().getText());

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
