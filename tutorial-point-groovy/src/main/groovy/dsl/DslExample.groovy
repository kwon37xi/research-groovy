package dsl

// groovy 는 최상위 구문에서 메소드 호출시 괄호를 생략할 수 있도록 허용한다.
// 따라서 a b c d 라는 구문은 a(b).c(d) 라고 해석된다.
class DslExample {
    static void main(String[] args) {
        def emailDsl = EmailDsl.make {
            to "Nirav Assar"
            from "Barack Obama"
            body "How are thins? We are doing well. Take case."
        }

        println emailDsl
    }
}
