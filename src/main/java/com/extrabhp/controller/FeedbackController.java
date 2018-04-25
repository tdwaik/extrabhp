package com.extrabhp.controller;

import com.extrabhp.controller.RESTful.helper.AddFeedbackRequest;
import com.extrabhp.entity.Feedback;
import com.extrabhp.model.FeedbackModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
@Path("feedback")
public class FeedbackController {

    private final static Logger LOGGER = Logger.getLogger(FeedbackController.class.getName());

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWhatCar(AddFeedbackRequest addFeedbackRequest) {
        try {
            if(addFeedbackRequest.getContent() == null
                    || addFeedbackRequest.getContent().isEmpty()
                    || addFeedbackRequest.getContent().length() < 3) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            Feedback feedback = new Feedback();
            feedback.setEmail(addFeedbackRequest.getEmail())
                    .setContent(addFeedbackRequest.getContent());

            FeedbackModel feedbackModel = new FeedbackModel();
            feedbackModel.addFeedback(feedback);

            return Response.status(Response.Status.CREATED).build();

        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
