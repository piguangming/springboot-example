package shiro;

@Service
public class UserService {
    private UserDAO userDAO;
    public User findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userDAO.findByName(username);
    }
}