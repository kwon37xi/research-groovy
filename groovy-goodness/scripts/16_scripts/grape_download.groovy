// Java System property groovy.grape.report.downloads=true 로 의존성 다운로드 현황을 볼 수 있음.
// Java System property ivy.message.logger.level=0-4 : 0=error

import org.apache.commons.lang3.SystemUtils
import static org.apache.commons.lang3.JavaVersion.JAVA_1_8 as Java8

@Grab(group='org.apache.commons', module='commons-lang3', version='3.4')
def printInfo() {
    if (SystemUtils.isJavaVersionAtLeast(Java8)) {
        println 'We are ready to use the Stream API in our code.'
    } else {
        println 'We cannot use the Stream API in our code.'
    }
}


printInfo()