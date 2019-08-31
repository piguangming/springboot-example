package com.techprimers.kafka.springbootkafkaproducerexample.controller;

import com.techprimers.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";
//    private static final String TOPIC = "piguangming-test-jdjr";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }

    @GetMapping("/send/{name}")
    public String send(@PathVariable("name") final String name) {
        ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));;
        future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Produce: The message failed to be sent:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, User> stringObjectSendResult) {
                System.out.println("Produce: The message was sent successfully:");
                System.out.println("Produce: _+_+_+_+_+_+_+ result: " + stringObjectSendResult.toString());
            }
        });

        return "Published successfully";
    }
}
