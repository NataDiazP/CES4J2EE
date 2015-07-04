/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author Natalia
 */
@MessageDriven(mappedName = "jms/TestQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "connectionFactoryLookup", propertyValue = "jms/TestQueue")
})
public class SampleMDB implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;
    
    public SampleMDB() {
    }

    @Override
    public void onMessage(Message message){
        if (message instanceof TextMessage) {
            TextMessage m = (TextMessage) message;
            try {
                System.out.println(m.getText());
            } catch (JMSException ex) {
                mdc.setRollbackOnly();
            }
        } else if (message instanceof ObjectMessage) {
            ObjectMessage o =(ObjectMessage) message;
            try {
                System.out.println(o.getObject());
            } catch (JMSException e) {
                mdc.setRollbackOnly();
            }
        }
    }

}
