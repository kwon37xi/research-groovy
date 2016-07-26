package research.spock;

public class UserController {
    private UserService userService;
    private Publisher publisher;

    public String findUserNameById(Long userId) {
        final String userName = userService.findUserNameById(userId);
        publisher.send("find userName by userId " + userId + " result : " + userName);
        return userName;
    }
}
