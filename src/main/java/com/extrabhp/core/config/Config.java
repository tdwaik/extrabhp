package com.extrabhp.core.config;

import com.extrabhp.core.App;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Thaer AlDwaik <thaer_aldwaik@hotmail.com>
 * @since February 14, 2016.
 */
public class Config {

    private static InputStream input = null;

    private static Properties prop = null;

    public static String getConfig(String key) {

        if(input == null) {
            try {
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                input = classLoader.getResourceAsStream("config/config.properties");

                // load a properties file
                prop = new Properties();
                prop.load(input);

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return prop.getProperty(key);

    }

}
