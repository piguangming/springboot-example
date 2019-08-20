package feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    Proxy proxy;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return proxy.hello(name);
    }

}
