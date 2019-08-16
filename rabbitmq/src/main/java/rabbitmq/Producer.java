package rabbitmq;
/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Producer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	int count = 1;

	@Scheduled(fixedRate = 1000 )
	void pub() {
		String msg = count++ + "";
		System.out.println(Thread.currentThread().getName() + "线程发布消息："  + msg + " " + new Date());
		rabbitTemplate.convertAndSend("queue", msg);
	}
}
