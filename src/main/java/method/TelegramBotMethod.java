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

    // All subclass must override this method, or else it will throw an exception
    public <T> void execute(T... args) throws RuntimeException {
        throw MethodNotDefined(endpoint, "executeMethod");
    }

    private static RuntimeException MethodNotDefined(String endpoint, String methodName) {
        return new RuntimeException("In " + endpoint + " method: " + methodName + ": this method is not defined");
    }
}
