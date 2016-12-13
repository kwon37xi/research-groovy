// @Grapes 에 여러 @Grab 넣을 수 있음.

// 기본적으로 의존성은 Groovy script와 동일한 클래스로더에 등록된다.
// 하지만 JDBC Driver는 System Classloader에 있어야만 한다.
// 이는 DriverManager 클래스가 오직 System Classloader만 읽을 수 있기 때문이다.
// 그렇지 않으면 java.sql.SQLException: No suitable driver found. 예외 발생.


@Grapes([
    @Grab('org.slf4j:slf4j-simple:1.5.11'),
    @Grab('mysql:mysql-connector-java:5.1.12'),
    @GrabConfig(systemClassLoader = true)
])
import org.slf4j.*
import groovy.sql.*

def logger = LoggerFactory.getLogger('sql')
logger.info 'Initialize SQL'

def username = args[0]
def password = args[1]
def sql = Sql.newInstance('jdbc:mysql://localhost:3306/test', username, password, 'com.mysql.jdbc.Driver')

logger.info "Got mysql a SQL connection: $sql"