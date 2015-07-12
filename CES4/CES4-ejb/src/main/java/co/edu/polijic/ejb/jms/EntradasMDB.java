/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb.jms;

import co.edu.polijic.ejb.PagosUtil;
import co.edu.polijic.pagos.modelos.Transaccion;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 *
 * @author felipe
 */
@MessageDriven(mappedName = "jms/InputQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "connectionFactoryLookup", propertyValue = "jms/InputQueue")
})
public class EntradasMDB implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;

    public EntradasMDB() {
    }

    public static void main(String[] args) throws NamingException, JMSException {
        Connection connection = null;
        try {
            System.out.println("Create JNDI Context");
            Context context = PagosUtil.getInitialContext();

            System.out.println("Get connection facory");
            ConnectionFactory connectionFactory = (ConnectionFactory) context
                    .lookup("ConnectionFactory");

            System.out.println("Create connection");
            connection = (Connection) connectionFactory.createConnection();

            System.out.println("Create session");
            Session session = connection.createSession(false,
                    QueueSession.AUTO_ACKNOWLEDGE);

            System.out.println("Lookup queue");
            Queue queue = (Queue) context.lookup("/queue/PagosQueue");

            System.out.println("Start connection");
            connection.start();

            System.out.println("Create consumer");
            MessageConsumer consumer = session.createConsumer(queue);

            consumer.setMessageListener((MessageListener)new Transaccion());    
        } finally {
            if (connection != null) {
                System.out.println("close the connection");
                connection.close();
            }
        }
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage m = (TextMessage) message;
            try {
                System.out.println(m.getText());
            } catch (JMSException ex) {
                mdc.setRollbackOnly();
            }
        } else if (message instanceof ObjectMessage) {
            ObjectMessage o = (ObjectMessage) message;
            try {
                System.out.println(o.getObject());
            } catch (JMSException e) {
                mdc.setRollbackOnly();
            }
        }
    }

}
