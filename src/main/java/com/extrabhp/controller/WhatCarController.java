package com.extrabhp.controller;

import com.extrabhp.controller.RESTful.helper.WhatCar.Feedback;
import com.extrabhp.controller.RESTful.helper.WhatCar.IsHelpful;
import com.extrabhp.core.WhatCar;
import com.extrabhp.entity.WhatCarLog;
import com.extrabhp.model.WhatCarModel;
import com.google.gson.Gson;
import org.json.JSONObject;

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
@Path("whatCar")
public class WhatCarController extends AbstarctController {

    private final static Logger LOGGER = Logger.getLogger(WhatCarController.class.getName());

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWhatCar(MultivaluedMap<String, String> answers) {

        try {
            if(answers == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            Map<String, String> qname = WhatCar.getNextQuestion(answers);

            if(qname.containsKey("next")) {
                JSONObject question = WhatCar.getQuestion(qname.get("next"));
                String next = question.toString();
                if(next.isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).build();
                }

                return Response.ok().entity(next).build();
            }else if(qname.containsKey("result")) {

                WhatCarLog whatCarLog = new WhatCarLog();
                String result = qname.get("result");
                Gson gson = new Gson();
                whatCarLog.setAnswers(gson.toJson(answers))
                        .setResult(qname.get("result"))
                        .setStatus(result.equals(WhatCar.noResults)? 404 : 200);
                WhatCarModel whatCarModel = new WhatCarModel();
                int whatCarLogId = whatCarModel.addWhatCar(whatCarLog);

                Map<String, String> response = new HashMap<>();
                response.put("result", result);
                response.put("whatCarLogId", Integer.toString(whatCarLogId));
                return Response.status(Response.Status.CREATED).entity(toJson(response)).build();
            }

            return Response.status(Response.Status.BAD_REQUEST).build();

        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/isHelpful")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addIsHelpful(IsHelpful isHelpful) {
        try {
            WhatCarModel whatCarModel = new WhatCarModel();
            WhatCarLog whatCarLog = new WhatCarLog();

            whatCarLog.setIsHelpful(isHelpful.getIsHelpful())
                    .setId(isHelpful.getWhatCarLogId());

            whatCarModel.addIsHelpful(whatCarLog);

            return Response.status(Response.Status.CREATED).build();
        }catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/feedback")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFeedback(Feedback feedback) {
        try {
            WhatCarModel whatCarModel = new WhatCarModel();
            WhatCarLog whatCarLog = new WhatCarLog();

            whatCarLog.setFeedback(feedback.getFeedback())
                    .setId(feedback.getWhatCarLogId());

            whatCarModel.addFeedback(whatCarLog);

            return Response.status(Response.Status.CREATED).build();
        }catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
