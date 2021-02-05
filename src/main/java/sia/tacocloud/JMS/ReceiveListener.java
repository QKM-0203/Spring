package sia.tacocloud.JMS;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveListener {

    @JmsListener(destination = "First_Message")
    public  void dealWith(Message message){
        System.out.println(message.getText()+" "+message.getDate());
    }

}
