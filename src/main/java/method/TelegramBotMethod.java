package method;

import config.Config;

/**
 * Created by shafiq on 29/01/16.
 */
public abstract class TelegramBotMethod {

    // The url to do the HTTP request
    private static String url = Config.getURL() + Config.getAPIKey();

    private String endpoint;

    public String getFullUrl() {
        return fullUrl;
    }

    private String fullUrl;

    public TelegramBotMethod(String endpoint){
        this.endpoint = endpoint;
        fullUrl = url + endpoint;
    }

    // All subclass must override this method, or else it will throw an exception
    public void executeMethod(String... args) throws RuntimeException {
        throw MethodExecutionNotDefined();
    }

    private static RuntimeException MethodExecutionNotDefined() {
        return new RuntimeException("The execution of this method is not defined");
    }
}
