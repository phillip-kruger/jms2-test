package com.github.phillipkruger.jms2test;

import java.util.logging.Level;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;

import javax.jms.Message;
import javax.jms.MessageListener;
import lombok.extern.java.Log;

@Log

@MessageDriven(mappedName="java:app/testQueue",activationConfig =  {
    @ActivationConfigProperty(propertyName = "destinationType",
                              propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination",
            propertyValue = "testQueue")
})
public class TestConsumer implements MessageListener {
    
    @Override
    public void onMessage(Message message) {
        try {
            String m = message.getBody(String.class);
            log.log(Level.SEVERE, "JMS: [{0}]", m);
        } catch (JMSException ex) {
            throw new RuntimeException(ex);
        }
    }
}
