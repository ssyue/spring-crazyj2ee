package jms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;


public class Receiver {
    public Mail receiveMail(){
        ConnectionFactory cf =new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination destination=new ActiveMQQueue("mail.queues");
        javax.jms.Connection conn=null;
           try {
            conn=cf.createConnection();
            Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
           
            MessageConsumer consumer=session.createConsumer(destination);
            conn.start();
            
            javax.jms.Message message=consumer.receive();
            Mail mail=new Mail();
            mail.setMail(message.getStringProperty("mail"));
            mail.setName(message.getStringProperty("name"));
            mail.setWeight(message.getDoubleProperty("weight"));
            
            session.close();
            return mail;
        }
        catch (JMSException e) {
            e.printStackTrace();
        }finally{
            if(conn!=null)
                try {
                    conn.close();
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
        }
           
        return null;
}}
