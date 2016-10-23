def list = ['Gr', 'vy']
assert list.plus(1, 'oo') == ['Gr', 'oo', 'vy'] // original list NOT changed
assert list == ['Gr', 'vy']

list.addAll(1, 'oo') // Original list CHANGED
assert list == ['Gr', 'oo', 'vy']

assert (1..10).plus(5, 6..7) == [1, 2, 3, 4, 5, 6, 7, 6, 7, 8, 9, 10]