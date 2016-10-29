// closure는 메소드의 인자가 되거나 변수로 선언할 수 있다.
// 메소드나 다른 클로저의 리턴값이 될 수도 있다.
// closure() 혹은 closure.call() 로 호출가능.

def repeater(times) {
    { value -> value * times }
}
assert repeater(2).call('mrhaki') == 'mrhakimrhaki'
assert repeater(2)('mrhaki') == 'mrhakimrhaki'

// transformer closure를 인자로 받음. transformer 기본 구현을 { it } 으로 지정.
def repeater = { times, transformer = { it } ->
    { value -> transformer(value) * times }
}

assert repeater(2).call('mrhaki') == 'mrhakimrhaki' // 기본구현
assert repeater(2)('mrhaki') == 'mrhakimrhaki'

assert repeater(2) { it.toUpperCase() }('mrhaki') == 'MRHAKIMRHAKI'
assert repeater(2, { it.reverse() })('mrhaki') == 'ikahrmikahrm'
