package com.extrabhp.model;

import com.extrabhp.entity.WhatCarLog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class WhatCarModel extends AbstractModel {

    private final static Logger LOGGER = Logger.getLogger(WhatCarModel.class.getName());

    public int addWhatCar(WhatCarLog whatCarLog) {
        try {
            String query = "INSERT INTO " + WhatCarLog.tableName + " (answers, result, status) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = dbCconnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, whatCarLog.getAnswers());
            preparedStatement.setString(2, whatCarLog.getResult());
            preparedStatement.setInt(3, whatCarLog.getStatus());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            LOGGER.warning("Can't insert WhatCarLog!");

            return 0;
        }catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }

        return 0;
    }

    public boolean addIsHelpful(WhatCarLog whatCarLog) {
        try {
            ResultSet resultSet = executeQuery("SELECT is_helpful FROM " + WhatCarLog.tableName + " WHERE id = " + whatCarLog.getId());

            if(resultSet.next()) {
                resultSet.getInt("is_helpful");
                if(resultSet.wasNull()) {
                    String query = "UPDATE " + WhatCarLog.tableName + " SET is_helpful = ? WHERE id = ?";
                    preparedStatement = dbCconnection.prepareStatement(query);
                    preparedStatement.setInt(1, whatCarLog.getIsHelpful());
                    preparedStatement.setInt(2, whatCarLog.getId());
                    preparedStatement.executeUpdate();

                    return true;
                }
            }

        }catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }

        return false;
    }

    public boolean addFeedback(WhatCarLog whatCarLog) {
        try {
            ResultSet resultSet = executeQuery("SELECT feedback FROM " + WhatCarLog.tableName + " WHERE id = " + whatCarLog.getId());

            if(!resultSet.next() &&
                    (resultSet.getString("feedback") == null || resultSet.getString("feedback").isEmpty())) {
                String query = "UPDATE " + WhatCarLog.tableName + " SET feedback = ? WHERE id = ?";
                PreparedStatement preparedStatement = dbCconnection.prepareStatement(query);
                preparedStatement.setString(1, whatCarLog.getFeedback());
                preparedStatement.setInt(2, whatCarLog.getId());
                preparedStatement.executeUpdate();

                return true;
            }

        }catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }

        return false;
    }

}
