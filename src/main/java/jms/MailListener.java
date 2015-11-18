package jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class MailListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        Mail mail = new Mail();
        MapMessage m=(MapMessage)message;
        try {
            mail.setMail(m.getString("mailID"));
            mail.setWeight(m.getDouble("weight"));
            mail.setName(m.getString("name"));
        }
        catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        display(mail);
    }

    private void display(Mail mail) {
        System.out.println(mail.getMail()+","+mail.getName()+","+mail.getWeight());
    }

}
