package jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.annotation.Transactional;

public class JmsTemplateSender {
    @Resource
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination destination;
    @Transactional
    void sendMail(final Mail mail) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public MapMessage createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setString("mailID", mail.getMail());
                message.setString("name", mail.getName());
                message.setDouble("weight", mail.getWeight());
                return message;
            }
        });
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
