package cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    // GET http://localhost:8080/1
    @GetMapping("{id}")
    public String test(@PathVariable("id") String id) {
        return cacheService.get(id);
    }

    // DELETE http://localhost:8080/1
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") String id) {
        return cacheService.delete(id);
    }

//    POST HTTP/1.1
//    Host: http://localhost:8080?id=1&value=pi
    @PostMapping
    public String save(@RequestParam("id") String id, @RequestParam("value") String value) {
        return cacheService.save(id, value);
    }

    // PUT http://localhost:8080/1?value=piguangming1
    @PutMapping("{id}")
    public String update(@PathVariable("id") String id, @RequestParam("value") String value) {
        return cacheService.update(id, value);
    }
}
