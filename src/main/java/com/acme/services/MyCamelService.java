package com.acme.services;

import org.apache.camel.builder.RouteBuilder;

public class MyCamelService extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("restlet:/v1/myService") 
          .setBody().constant("<html><body><b>Hello World!</b></body></html>")
          .setHeader("Content-Type", constant("text/html"));
    }
}
