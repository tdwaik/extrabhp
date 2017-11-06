package com.extrabhp.core.config;

import com.extrabhp.core.DI;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class Config {

    private static InputStream input = null;

    private static Properties prop = null;

    private static final Logger LOGGER = Logger.getLogger(Config.class.getName());

    /**
     * @param key
     * @return String
     */
    public static String getConfig(String key) {

        if(input == null) {
            try {
                input = DI.readResourceAsStream("config/config.properties");

                // load a properties file
                prop = new Properties();
                prop.load(input);

            } catch (IOException e) {
                LOGGER.severe(e.getMessage());
                return null;
            }
        }

        return prop.getProperty(key);

    }

}
