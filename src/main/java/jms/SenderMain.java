package jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SenderMain {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("jms-beans.xml");
        Sender sender=(Sender) context.getBean("sender");
        sender.sendMail(new Mail("123456","hello" ,1.10));
    }

}
