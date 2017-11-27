package com.github.phillipkruger.jms2test;

import java.util.logging.Level;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import lombok.extern.java.Log;

@Log
@Stateless
@JMSDestinationDefinition(
    name="java:app/testQueue",
    interfaceName="javax.jms.Queue",
    destinationName="testQueue")
public class TestProducer {

    @Resource(lookup = "java:app/testQueue")
    private Queue queue;
    
    @Inject
    private JMSContext context;
    
    public void sendMessage(String message) throws JMSException{
        JMSProducer producer = context.createProducer();
        producer.send(queue, message);
        log.log(Level.SEVERE, "JMS: Added message to test queue [{0}]", queue.getQueueName());
    }
}