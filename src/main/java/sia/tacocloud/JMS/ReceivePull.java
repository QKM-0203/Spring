package sia.tacocloud.JMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 拉取模式，会有堵塞的状况存在
 */

@Component
public class ReceivePull {
    private final JmsTemplate jmsTemplate;

    @Autowired
    public ReceivePull(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void receive(){
        Message message = (Message) jmsTemplate.receiveAndConvert("First_Message");
        System.out.println(message.getText()+" "+message.getDate().getTime());
    }
}
