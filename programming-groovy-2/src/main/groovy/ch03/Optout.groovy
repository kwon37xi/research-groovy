package ch03

import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode

// @TypeChecked 는 컴파일시 타입 체킹만 할 뿐 bytecode 최적화는 무관하다.
@TypeChecked
class Sample {
    def method1() {
    }

    @TypeChecked(TypeCheckingMode.SKIP)
    def method2(String str) {
        str.shout() // 컴파일 에러 안남.
    }
}

str = 'hello'
str.metaClass.shout = { -> toUpperCase() }

Sample sample = new Sample()
println sample.method2(str)