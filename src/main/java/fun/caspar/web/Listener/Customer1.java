package fun.caspar.web.Listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "caspar")
public class Customer1 {

    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("111caspar接收到的消息:" + message);
    }
}
