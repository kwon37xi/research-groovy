def list = ['Groovy', 'is', 'great!']

assert list.pop() == 'great!' // 마지막 요소 제거하고 리턴
assert list == ['Groovy', 'is']

list.pop()

list.push('rocks!')
assert list == ['Groovy', 'rocks!']