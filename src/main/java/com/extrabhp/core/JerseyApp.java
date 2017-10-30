package com.extrabhp.core;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * @author Thaer AlDwaik <t_dwaik@hotmail.com>
 */

@ApplicationPath("/")
public class JerseyApp extends ResourceConfig {

    public JerseyApp() {
        packages("com.extrabhp");
        //register(MultiPartFeature.class);
    }

}
