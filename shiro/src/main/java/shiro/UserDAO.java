package shiro;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User,Long> {
    public User findByName(String name);
}