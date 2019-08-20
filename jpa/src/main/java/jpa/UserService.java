package jpa;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    @Scheduled(fixedRate = 1000)
    void findByName() {
        System.out.println(userRepository.findByName("piguangming"));
    }
}
