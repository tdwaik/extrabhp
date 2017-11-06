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

        }catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }

        return 0;
    }

    public void addIsHelpful(WhatCarLog whatCarLog) {
        try {
            String query = "UPDATE " + WhatCarLog.tableName + " SET is_helpful = ? WHERE id = ?";
            PreparedStatement preparedStatement = dbCconnection.prepareStatement(query);
            preparedStatement.setInt(1, whatCarLog.getIsHelpful());
            preparedStatement.setInt(2, whatCarLog.getId());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
    }

    public void addFeedback(WhatCarLog whatCarLog) {
        try {
            String query = "UPDATE " + WhatCarLog.tableName + " SET feedback = ? WHERE id = ?";
            PreparedStatement preparedStatement = dbCconnection.prepareStatement(query);
            preparedStatement.setString(1, whatCarLog.getFeedback());
            preparedStatement.setInt(2, whatCarLog.getId());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
    }

}
