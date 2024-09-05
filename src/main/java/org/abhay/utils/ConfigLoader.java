package org.abhay.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;
    private ConfigLoader(){
        try {
            properties = loadDefaultProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader==null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getPropertyValue(String property){
        return properties.getProperty(property);
    }

    private Properties loadDefaultProperties() throws IOException {
        return loadProperties("config.properties");
    }

    private Properties loadProperties(String configFileName) throws IOException {
        InputStream inStream = ClassLoader.getSystemClassLoader().getResourceAsStream(configFileName);
        Properties properties = new Properties();
        properties.load(inStream);
        return properties;
    }

}

