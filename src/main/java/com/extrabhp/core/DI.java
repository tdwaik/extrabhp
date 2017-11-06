package com.extrabhp.core;

import com.extrabhp.core.config.Config;
import com.extrabhp.core.utils.MySql;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class DI {

    private static Connection mysql = null;

    private final static Logger LOGGER = Logger.getLogger(DI.class.getName());

    /**
     * @return Connection
     */
    public static Connection Mysql() {

        try {
            if(mysql == null || mysql.isClosed()) {
                MySql mySql = new MySql();

                mysql = mySql.setHost(Config.getConfig("mysql.host").trim())
                        .setPort(Integer.parseInt(Config.getConfig("mysql.port").trim()))
                        .setUser(Config.getConfig("mysql.user").trim())
                        .setPassword(Config.getConfig("mysql.password").trim())
                        .setDatabaseName(Config.getConfig("mysql.database_name").trim())
                        .connect();
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.severe(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }

        return mysql;
    }

    /**
     * @param resource
     * @return URL
     */
    public static URL readResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    /**
     * @param resource
     * @return InputStream
     */
    public static InputStream readResourceAsStream(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResourceAsStream(resource);
    }

}
