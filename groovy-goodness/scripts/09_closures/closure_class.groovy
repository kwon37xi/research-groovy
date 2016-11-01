// Closure 클래스를 상속하고 구현할 수 있다.
// 상속시에 doCall() [임의의 파라미터, 임의의 리턴 타입 선언가능]메소드를 오버라이드할 수 있다.

class IsNumber extends Closure<Boolean> {
    IsNumber() {
        super(null)
    }

    Boolean doCall(final Object value) {
        value in Number
    }
}

def list = ['a', 100, 'Groovy', 1, 8, 42.0, true]

def numbers = list.findAll(new IsNumber())
println numbers

assert numbers == [100, 1, 8, 42.0]