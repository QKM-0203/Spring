package sia.tacocloud.JMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.util.Date;

@Service
public class SendMessageImp implements SendService{
    private final JmsTemplate jmsTemplate;

    @Autowired
    public SendMessageImp(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void SendMessage() {
        Message message = new Message();
        message.setDate(new Date());
        message.setText("JMS的消息");
        //send 和 convertAndSend 区别是send不能直接发送对象，只能传入消息对象，而后者可以传入对象，内部会进行对象转为消息
        //参数依次为目的地 ，消息内容，消息的中间处理，可以添加一些东西
        jmsTemplate.convertAndSend("First_Message", message, new MessagePostProcessor() {
            @Override
            public javax.jms.Message postProcessMessage(javax.jms.Message message) throws JMSException {
                message.setStringProperty("origin","web");
                return message;
            }
        });
    }
}
