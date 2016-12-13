// repository 추가 : ~/.groovy/grapeConfig.xml ivy config 파일.
// ~/.groovy/grapes 에 의존성 파일 다운로드됨.
// 명령행 grape 명령으로 의존성 다운로드 가능.
// grape list : 이미 다운로드된 의존성 목록

import org.apache.commons.lang.SystemUtils

@Grab(group='commons-lang', module='commons-lang', version='2.4')
def printInfo() {
    if (SystemUtils.isJavaVersionAtLeast(5)) {
        println 'We are ready to use annotations in our Groovy code.'
    } else {
        println 'We cannot use annotations in our Groovy code.'
    }
}

printInfo()