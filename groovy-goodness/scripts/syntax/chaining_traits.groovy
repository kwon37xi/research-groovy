import javax.xml.crypto.dsig.Transform

// traits since 2.3
// trait의 순서가 체인의 순서를 결정한다. 마지막 선언된 것이 제일 처음 호출된다.
// 즉, 오른쪽 -> 왼쪽 순서로 호출된다.

interface Transformer {
    String transform(String input)
}

trait DefaultTransformer implements Transformer {
    String transform(String input) {
        input
//        super.transform(input)  //하면 무슨일이 생기나? 예외 발생한다.
    }
}

trait Upper implements Transformer {
    String transform(String input) {
        super.transform(input.toUpperCase()) // 대문자 변환 후 상위 trait에 chaining
    }
}

trait Filter implements Transformer {
    @Override
    String transform(String input) {
        super.transform(input - 'mr')
    }
}

// Filter -> Upper -> Default 순서로 실행됨.
class StringTransformer implements DefaultTransformer, Upper, Filter {
    String value

    String getValue() { transform(value) }
}

def transformer = new StringTransformer(value: 'mrhaki')

assert transformer.value == 'HAKI'

// Upper -> Filter -> Default 순서로 실행됨.
class OtherStringTransformer implements DefaultTransformer, Filter, Upper {
    String value
    String getValue() { transform(value) }
}

def otherTransformer = new OtherStringTransformer(value: 'mrhaki')

// Filter가 'mr'을 못찾고 그냥 통과 시킴
assert otherTransformer.value == 'MRHAKI'

// 5글자 미만만 통과시킨다.
trait SmallFilter implements Transformer {
    String transform(String input) {
        if (input.size() < 5) {
            super.transform(input)
        } else {
            ''
        }
    }
}

class SmallStringTransformer implements DefaultTransformer, Upper, SmallFilter {
    String value
    String getValue() { transform(value) }
}

def smallTransformer = new SmallStringTransformer(value: 'mrhaki')
assert smallTransformer.value == '' // 5글자 넘어서 SmallFilter에서 걸림

smallTransformer.value = 'haki'
assert smallTransformer.value == 'HAKI'