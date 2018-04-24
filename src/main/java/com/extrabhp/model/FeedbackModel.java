package com.extrabhp.model;

import com.extrabhp.entity.Feedback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class FeedbackModel extends AbstractModel {

    private final static Logger LOGGER = Logger.getLogger(FeedbackModel.class.getName());

    public int addFeedback(Feedback feedback) throws Exception {
        try {
            String query = "INSERT INTO " + Feedback.tableName + " (email, content) VALUES (?, ?)";
            PreparedStatement preparedStatement = dbCconnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, feedback.getEmail());
            preparedStatement.setString(2, feedback.getContent());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }


            String exceptionMessage = "Can't insert Feedback!";
            LOGGER.warning(exceptionMessage);
            throw new Exception(exceptionMessage);

        }catch (Exception e) {
            LOGGER.warning(e.getMessage());
            throw e;
        }
    }


}
