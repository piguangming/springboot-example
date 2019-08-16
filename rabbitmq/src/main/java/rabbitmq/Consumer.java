package rabbitmq;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue")
public class Consumer {

	@RabbitHandler
	public void sub(String queue) {
		System.out.println(Thread.currentThread().getName() + "线程订阅消息：" + queue);
	}

}
