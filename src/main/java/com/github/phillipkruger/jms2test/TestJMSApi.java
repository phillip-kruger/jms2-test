package com.github.phillipkruger.jms2test;

import javax.inject.Inject;
import javax.jms.JMSException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class TestJMSApi {
    
    @Inject 
    private TestProducer testProducer;
    
    @GET
    public Response hello() throws JMSException {
        testProducer.sendMessage("Hello world");
        return Response.accepted().build();
    }
    
}