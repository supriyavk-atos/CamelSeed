package com.acme.services;
 
import org.apache.camel.builder.RouteBuilder;
 
public class AccountsService extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("restlet:/accounts")
          .setBody().constant("[{\"name\":\"Vladimir\",\"amount\":1480},{\"name\":\"Hannah\",\"amount\":1263},{\"name\":\"Terry\",\"amount\":389},{\"name\":\"Anita\",\"amount\":561}]")
          .setHeader("Content-Type", constant("application/json"));
    }
}