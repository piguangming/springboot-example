package activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class MQ {
	@Bean
	public Queue queue() {
		String topic = "sample.queue";
		System.out.println(Thread.currentThread().getName() + " 创建MQ主题：" + topic);
		return new ActiveMQQueue(topic);
	}
}
