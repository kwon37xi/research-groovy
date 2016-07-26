import research.spock.Publisher
import research.spock.UserController
import research.spock.UserService
import spock.lang.Specification


class MockInjection extends Specification {
    UserController userController

    UserService userService = Mock()
    Publisher publisher = Mock()

    void setup() {
        // 테스트 대상 객체에 모의 객체 주입 편하게 하기
        userController = new UserController(userService: userService, publisher: publisher)
    }

    def "findUserNameById"() {
        given:
        def userId = 123456L;
        def expectedUserName = "Spock"

        when:
        def result = userController.findUserNameById(userId)

        then:
        result == expectedUserName
        1 * userService.findUserNameById(userId) >> expectedUserName
        1 * publisher.send("find userName by userId 123456 result : Spock")
    }
}