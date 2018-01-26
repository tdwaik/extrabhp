package com.extrabhp.core;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Thaer AlDwaik <t_dwaik@hotmail.com>
 */
@Provider
public class CORSResponseFilter implements ContainerResponseFilter {

    private final static Logger LOGGER = Logger.getLogger(CORSResponseFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {

        try {
            List<String> originList = requestContext.getHeaders().get("Origin");

            if(originList.get(0).equals("https://extrabhp.com") || originList.get(0).equals("http://extrabhp.com") || originList.get(0).equals("http://dev.extrabhp.com")) {
                MultivaluedMap<String, Object> headers = responseContext.getHeaders();

                headers.add("Access-Control-Allow-Origin", originList.get(0));
                headers.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
                headers.add("Access-Control-Allow-Headers", "Content-Type, X-Requested-With, accept, Origin, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
                headers.add("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, Authorization, Access-Control-Preflight-Maxage");
                headers.add("Access-Control-Preflight-Maxage", "600");
            }else {
                LOGGER.info(originList.toString());
                responseContext.setEntity(null);
                responseContext.setStatus(Response.Status.NOT_FOUND.getStatusCode());
            }
        }catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }

    }

}
