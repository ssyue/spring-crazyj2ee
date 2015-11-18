package jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsMail {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("jmsTemplate-beans.xml");
        JmsTemplateSender sender=(JmsTemplateSender) app.getBean("jmsTemplateSender");
        sender.sendMail(new Mail("123","hello",1.10));
     /*   JmsTemplateReceiver receiver=(JmsTemplateReceiver) app.getBean("jmsTemplateReceiver");
        Mail mail=receiver.recieveMail();
        System.out.println(mail.getMail()+","+mail.getName()+","+mail.getWeight());*/
    }
}
