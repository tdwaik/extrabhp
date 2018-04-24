package com.extrabhp.model;

import com.extrabhp.controller.RESTful.helper.CarsTimeline.CarsTimelineResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class CarsTimelineModel extends AbstractModel {

    private final static Logger LOGGER = Logger.getLogger(CarsTimelineModel.class.getName());

    /**
     * @return ArrayList<CarsTimelineResponse>
     * @throws SQLException
     */
    public ArrayList<CarsTimelineResponse> getTimeline() throws SQLException {
        try {
            ResultSet resultSet = executeQuery("SELECT * FROM cars_timeline ORDER BY production_date DESC");

            ArrayList<CarsTimelineResponse> carsTimelineResponseList = new ArrayList<>();
            CarsTimelineResponse carsTimelineResponse;
            while(resultSet.next()) {
                carsTimelineResponse = new CarsTimelineResponse();
                carsTimelineResponse.setCode(resultSet.getString("code"));
                carsTimelineResponse.setTitle(resultSet.getString("title"));
                carsTimelineResponse.setDescription(resultSet.getString("description"));
                carsTimelineResponse.setImg(resultSet.getString("img"));
                Date date = resultSet.getDate("production_date");
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                carsTimelineResponse.setReleaseDate(Integer.toString(cal.get(Calendar.YEAR)));

                carsTimelineResponseList.add(carsTimelineResponse);
            }

            return carsTimelineResponseList;

        }catch (Exception e) {
            LOGGER.warning(e.getMessage());
            throw e;
        }
    }

}
