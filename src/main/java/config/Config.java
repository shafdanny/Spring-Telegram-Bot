package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shafiq on 29/01/16.
 */
public class Config {
    private static Properties prop = new Properties();
    private static InputStream input;
    private static Config config = new Config();

    public Config(){
        try {
            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getAPIKey(){
        // get the property value and test it existence
        String api = prop.getProperty("APIKey");
        return api;
    }

    public static String getURL(){
        // get the property value and test it existence
        String url = prop.getProperty("URL");
        return url;
    }
}
