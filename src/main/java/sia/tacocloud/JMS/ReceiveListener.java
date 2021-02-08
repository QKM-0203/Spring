package sia.tacocloud.JMS;

import org.springframework.stereotype.Component;

/**
 * 还没有安装消息代理器
 * 拉取模式和推送模式的区别就是，前者会一直等待客户端发送消息，不发就一直堵塞，而而后者是发送才接收
 */
@Component

public class ReceiveListener {

    //@JmsListener(destination = "First_Message")
    public  void dealWith(Message message){
        System.out.println(message.getText()+" "+message.getDate());
    }

}
