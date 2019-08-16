package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Redis {
    @Autowired
    private RedisTemplate redisTemplate;

    int pubCounter = 1;
    int subCounter = 1;

    @Scheduled(fixedRate = 1000 )
    void pub() {
        String msg = pubCounter++ + "";
        System.out.println(Thread.currentThread().getName() + "线程写消息：<"  + msg + "," + msg + "> " + new Date());
        redisTemplate.opsForValue().set(msg, msg);
    }

    @Scheduled(fixedRate =2000 )
    void sub() {
        String key = subCounter++ + "";
        String value = (String) redisTemplate.opsForValue().get(key);
        System.out.println(Thread.currentThread().getName() + "线程读消息：<"  + key + "," + value + "> " + new Date());
    }
}
