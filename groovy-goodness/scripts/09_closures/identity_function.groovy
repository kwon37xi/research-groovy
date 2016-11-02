// 객체를 있는 그대로 리턴하는 클로져. 클로져를 받는 메소드에서 디폴트 클로져 역할을 하기 좋음.
// http://mrhaki.blogspot.kr/2016/10/groovy-goodness-identity-closure.html

def identity = { a -> a}
assert identity(42) == 42
assert identity('Groovy rocks!') == 'Groovy rocks!'

assert Closure.IDENTITY('Groovy rocks!') == 'Groovy rocks!'
assert Closure.IDENTITY(['Groovy', 'is', 'gr8']) == ['Groovy', 'is', 'gr8']
assert Closure.IDENTITY(a: 1, b: 2, c: 3) == [a: 1, b: 2, c: 3]

import static groovy.lang.Closure.IDENTITY
assert IDENTITY(42) == 42

def theAnswer = IDENTITY.curry(42)
assert theAnswer() == 42

def transformString(String value, Closure transform = IDENTITY) {
    transform(value)
}

assert transformString('hubert') == 'hubert'
assert transformString('mrhaki') { s -> s.toUpperCase() } == 'MRHAKI'