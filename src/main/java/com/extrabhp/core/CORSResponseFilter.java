package com.extrabhp.core;

import com.extrabhp.core.config.Config;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.Arrays;
import java.util.List;

/**
 * @author Thaer AlDwaik <t_dwaik@hotmail.com>
 */
@Provider
public class CORSResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {

        List<String> originList = requestContext.getHeaders().get("Origin");

        String allowedOrigins = Config.getConfig("ALLOWED_ORIGINS");

//        if(!originList.isEmpty() && allowedOrigins != null && originList.get(0).matches(allowedOrigins)) {
            MultivaluedMap<String, Object> headers = responseContext.getHeaders();

            headers.add("Access-Control-Allow-Origin", originList.get(0));
            headers.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            headers.add("Access-Control-Allow-Headers", "Content-Type, X-Requested-With, accept, Origin, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
            headers.add("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, Authorization, Access-Control-Preflight-Maxage");
            headers.add("Access-Control-Preflight-Maxage", "600");
//        }else {
//            responseContext.setEntity(null);
//            responseContext.setStatus(Response.Status.BAD_REQUEST.getStatusCode());
//        }

    }

}
