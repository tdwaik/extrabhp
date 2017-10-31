package com.extrabhp.core;

import com.extrabhp.core.config.Config;
import com.extrabhp.core.utils.MySql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class DI {

    private static Connection mysql = null;

    public static Connection Mysql() {

        if(mysql == null) {
            MySql mySql = new MySql();
            try {
                mysql = mySql
                        .setHost(Config.getConfig("mysql.host").trim())
                        .setPort(Integer.parseInt(Config.getConfig("mysql.port").trim()))
                        .setUser(Config.getConfig("mysql.user").trim())
                        .setPassword(Config.getConfig("mysql.password").trim())
                        .setDatabaseName(Config.getConfig("mysql.database_name").trim())
                        .connect();
            } catch (SQLException | ClassNotFoundException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }


        return mysql;
    }

}
