// log annotation의 value 값으로 로그 객체 변경가능.
@Grapes(
        @Grab(group='ch.qos.logback', module='logback-classic', version="1.1.7")
)
import groovy.util.logging.Slf4j

@Slf4j(value = 'LOGGER', category='mrhaki.blog.samples')
class SimpleLogging {
    String sample(final String message) {
        LOGGER.info 'Running sample({}) method', message

        "Groovy is $message!"
    }
}

def s = new SimpleLogging()
println "System.out says: ${s.sample('gr8')}"