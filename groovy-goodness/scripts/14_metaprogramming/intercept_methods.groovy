// 메소드 호출을 중간에 가로챌 수 있다.
// Interceptor 인터페이스 구현.
// ProxyMetaClass 생성
// use()

class HelloInterceptor implements Interceptor {
    boolean invokeMethod = true

    boolean doInvoke() {
        invokeMethod
    }

    Object beforeInvoke(Object obj, String name, Object[] args) {
        // shout() 메소드 실행 금지
        if (name == 'shout') {
            invokeMethod = false
        }
    }

    Object afterInvoke(Object obj, String name, Object[] args, Object result) {
        if (name == 'shout') {
            invokeMethod = true
            // shout() 에 대해 대체 결과 설정
            result = "sssshhh... You don't have to shout."
        }
        result
    }
}

class Hello {
    String say() { "Hello Groovy" }
    String shout() { "HELLO GROOVY" }
}
def proxy = ProxyMetaClass.getInstance(Hello)
def interceptor = new HelloInterceptor()
proxy.interceptor = interceptor

proxy.use {
    def h = new Hello()
    assert h.say() == 'Hello Groovy'
    assert h.shout() == "sssshhh... You don't have to shout."
}