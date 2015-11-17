package jms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;


public class Sender {
    public void sendMail(Mail mail){
         ConnectionFactory cf =new ActiveMQConnectionFactory("tcp://localhost:61616");
         Destination destination=new ActiveMQQueue("mail.queues");
         javax.jms.Connection conn=null;
         try {
            conn=cf.createConnection();
            Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer pro=session.createProducer(destination);
            MapMessage message=session.createMapMessage();
            message.setString("mailID", mail.getMail());
            message.setString("name", mail.getName());
            message.setDouble("weight", mail.getWeight());
            pro.send(message);
            session.close();
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
         
    }
}
