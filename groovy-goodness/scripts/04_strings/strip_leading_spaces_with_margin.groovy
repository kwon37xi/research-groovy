def s = '''\
        |Groovy
        |Grails
        |Griffon'''

// 기본 마진 문자 |
assert '''\
Groovy
Grails
Griffon''' == s.stripMargin()

def s1 = '''\
    * Gradle
    * GPars
    * Spock'''

assert '''\
 Gradle
 GPars
 Spock''' == s1.stripMargin("* ")