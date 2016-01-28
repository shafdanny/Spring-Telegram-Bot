package config;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;


/**
 * Created by shafiq on 28/01/16.
 */
public class ConfigTest {
    private static Properties prop = new Properties();
    private static InputStream input;

    @Before
    public void testGetConfigFile(){

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

    @Test
    public void getAPIKey(){
        // get the property value and test it existence
        String api = prop.getProperty("APIKey");
        assertNotNull(api);
    }
}
