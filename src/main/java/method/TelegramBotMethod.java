package method;

import config.Config;

/**
 * Created by shafiq on 29/01/16.
 */
public abstract class TelegramBotMethod {

    // The url to do the HTTP request
    private static String url = Config.getURL() + Config.getAPIKey();

    private String endpoint;

    private String fullUrl;

    public String getFullUrl() {
        return fullUrl;
    }

    public TelegramBotMethod(String endpoint){
        this.endpoint = endpoint;
        fullUrl = url + endpoint;
    }


    public abstract <T> void execute(T... args);

}
