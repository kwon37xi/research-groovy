// Object asType(Class) 메소드 구현을 통해 특정 타입으로 컨버전 가능.
// as 키워드를 통해 호출

class Size {
    def x, y

    Object asType(Class clazz) {
        if (clazz == SquaredSize) {
            new SquaredSize(x: x**2, y: y**2)
        }
    }
}

class SquaredSize {
    def x, y
    String toString() { "x: $x, y: $y" }
}

def size = new Size(x: 10, y: 5)
def squared = size as SquaredSize // or size.asType(SquaredSize)

println squared

assert 100 == squared.x
assert 25 == squared.y
