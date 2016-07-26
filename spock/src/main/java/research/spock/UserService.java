package research.spock;

public class UserService {
    public String findUserNameById(Long userId) {
        return "name " + userId;
    }
}
