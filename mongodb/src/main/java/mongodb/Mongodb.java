package mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Mongodb {
    @Autowired
    private MongoTemplate mongoTemplate;

    int pubCounter = 1;
    int subCounter = 1;


    @Scheduled(fixedRate = 1000 )
    void create() {
        long id = pubCounter++;
        String name = "user" + pubCounter;
        System.out.println(Thread.currentThread().getName() + "线程写消息：<"  + id + "," + name + "> " + new Date());
        mongoTemplate.save(new User(id, name ));
    }

    @Scheduled(fixedRate =2000 )
    void select() {
        long id = subCounter++;
        User user = mongoTemplate.findById(id, User.class);
        System.out.println(Thread.currentThread().getName() + "线程读消息：<"  + user.id + "," + user.name + "> " + new Date());
    }
}
