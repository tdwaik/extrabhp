package com.extrabhp.controller;

import com.extrabhp.controller.RESTful.helper.CarsTimeline.CarsTimelineResponse;
import com.extrabhp.model.CarsTimelineModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */

@Path("carsTimeline")
public class CarsTimelineController extends AbstarctController {

    private final static Logger LOGGER = Logger.getLogger(CarsTimelineController.class.getName());

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeline() {
        try {
            CarsTimelineModel carsTimelineModel = new CarsTimelineModel();
            ArrayList<CarsTimelineResponse> carsTimelineResponseList = carsTimelineModel.getTimeline();

            return Response.ok().entity(toJson(carsTimelineResponseList)).build();
        }catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
