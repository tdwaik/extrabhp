package com.extrabhp.controller;

import com.extrabhp.core.WhatCar;
import com.extrabhp.entity.WhatCarLog;
import com.extrabhp.model.WhatCarModel;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
@Path("whatCar")
public class WhatCarController extends AbstarctController {

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWhatCar(MultivaluedMap<String, String> answers) {

        try {

            System.out.printf("%.3f MB", Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0));

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
                whatCarModel.addWhatCar(whatCarLog);


                return Response.status(Response.Status.CREATED).entity(toJson(qname.get("result"))).build();
            }

            return Response.status(Response.Status.BAD_REQUEST).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
