package utils;

import org.testng.Reporter;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private final Properties properties;
    public PropertyReader(String filename) {
        properties = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
            properties.load(inputStream);
        } catch (IOException e) {
            Reporter.log("There was an exception in loading properties file " + filename + " with exception" + e.getMessage());
        }
    }


    public String getProperty(String keyName) {
        String curr = System.getProperty(keyName);
        if (curr == null)
            curr = properties.getProperty(keyName);
        return curr;
    }



}
