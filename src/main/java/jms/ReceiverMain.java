package jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReceiverMain {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("jms-beans.xml");
        Receiver receiver = (Receiver) context.getBean("receiver");
        Mail mail=receiver.receiveMail();
        System.out.println("===="+mail.getName()+","+mail.getMail()+","+mail.getWeight());
    }
}
