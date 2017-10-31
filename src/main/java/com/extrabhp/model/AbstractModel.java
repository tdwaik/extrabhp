package com.extrabhp.model;

import com.extrabhp.core.DI;

import java.sql.*;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public abstract class AbstractModel {

    public Connection dbCconnection;

    public PreparedStatement preparedStatement;

    public AbstractModel() {
        dbCconnection = DI.Mysql();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        preparedStatement = dbCconnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        return preparedStatement.executeQuery();
    }

    public int executeUpdate(String query) throws SQLException {
        preparedStatement = dbCconnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        return preparedStatement.executeUpdate();
    }

}
