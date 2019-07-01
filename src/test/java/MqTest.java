import fun.caspar.HelloWorldApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloWorldApplication.class)
public class MqTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend() {
        rabbitTemplate.convertAndSend("caspar", "O(∩_∩)O哈哈~");
    }

    @Test
    public void testSendFanout() {
        rabbitTemplate.convertAndSend("chuanzhi", "", "分裂模式搞起来");
    }

    @Test
    public void testTopic1() {
        rabbitTemplate.convertAndSend("topictest", "good.aaa", "主题模式测试");
    }

    @Test
    public void testTopic2() {
        rabbitTemplate.convertAndSend("topictest", "article.content.log", "主题模式测试");
    }

    @Test
    public void testTopic3() {
        rabbitTemplate.convertAndSend("topictest", "good.log", "主题模式测试");
    }

}
