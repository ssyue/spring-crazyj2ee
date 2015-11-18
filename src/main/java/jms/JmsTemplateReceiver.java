package jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

public class JmsTemplateReceiver {
    @Resource
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination destination;
    @Transactional
    public Mail recieveMail() {
        MapMessage message = (MapMessage) jmsTemplate.receive(destination);
        Mail mail = new Mail();
        try {
            mail.setMail(message.getString("mailID"));
            mail.setWeight(message.getDouble("weight"));
            mail.setName(message.getString("name"));
        }
        catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mail;
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}
