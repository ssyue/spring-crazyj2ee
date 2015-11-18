package jms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Receiver {
public static void main(String[] args) {
    ApplicationContext context=new ClassPathXmlApplicationContext("jms-beans.xml");
    Receiver receiver = (Receiver) context.getBean("receiver");
    receiveMail();
}
    public static Mail receiveMail(){
        ConnectionFactory cf =new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination destination=new ActiveMQQueue("mail.queues");
        javax.jms.Connection conn=null;
           try {
            conn=cf.createConnection();
            Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
           
            MessageConsumer consumer=session.createConsumer(destination);
            conn.start();
            Mail mail=new Mail();
            while(true){
                MapMessage message=(MapMessage) consumer.receive(500000);
                System.out.println("===="+message.getString("name"));
         /*   javax.jms.TextMessage message=(TextMessage) consumer.receive(500000);
            System.out.println(message.getText());*/
            }
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
