class StringUtil {
    def static toSSN(self) { // Object self
        if (self.size() == 9) {
            "${self[0..2]}-${self[3..4]}-${self[5..8]}"
        }
    }
}

use(StringUtil) {
    println "123456789".toSSN()
    println new StringBuilder("987654321").toSSN()
}

try {
    println "123456789".toSSN()
} catch (MissingMethodException ex) {
    println ex.message
}

@Category(String)
class StringUtilAnnotated {
    def toSSN() {
        // String 객체 메소드로써 만든다.
        if (size() == 9) {
            "${this[0..2]}-${this[3..4]}-${this[5..8]}"
        }
    }
}

use(StringUtilAnnotated) {
    print "with annotatated @Category "
    println "123456789".toSSN()
}

class FindUtil {
    def static extractOnly(String self, closure) {
        def result = ''
        self.each {
            if (closure(it)) {
                result += it
            }
        }
        result
    }
}

use(FindUtil) {
    println "121254123".extractOnly {
        it == '4' || it == '5'
    }
}

use(StringUtil, FindUtil) {
    str = "123487651"

    println str.toSSN()
    println str.extractOnly { it == '8' || it == '1' }
}

/*
    Method Interception 방법을 보여준다.
    하지만 Category는 Method Injection 에 적합한 솔루션이므로 interception에는 가급적 사용하지 말 것.
 */
class ToStringHelper {
    def static toString(String self) {
        def method = self.metaClass.methods.find { it.name == 'toString' }
        '!!' + method.invoke(self, null) + '!!'
    }
}

use(ToStringHelper) {
    println 'hello'.toString()
}