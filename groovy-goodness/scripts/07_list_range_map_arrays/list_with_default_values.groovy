// withDefault() / withLazyDefault() : 기본값을 리턴하는 closure 를 지정. 해당 클로져는 존재하지 않는 index에도 접근가능.
// 요청한 인덱스가 현재 리스트 사이즈보다 크거가 같으면 리스트가 자동으로 확장되면서 그 사이 값은 Null로 채워진다.
// withEagerDefault() : 리스트 확장시 사이 값이 클로져의 리턴값으로 채워짐.

def lazy = ['abc', 42].withDefault { 'default' } // or .withLazyDefault
assert lazy[3] == 'default'
assert lazy == ['abc', 42, null, 'default']

assert lazy[2] == 'default' // 명시적 호출시점에 clojure에 있는 값으로 채워진다.
assert ['abc', 42, 'default', 'default'] == lazy

def eager = ['abc', 42].withEagerDefault { 'default' }
assert eager[3] == 'default'

assert eager == ['abc', 42, 'default', 'default']
assert eager[2] == 'default'

def sample = [1, 2, 3].withDefault { index -> index % 2 }
assert sample[3] == 1
assert sample[4] == 0