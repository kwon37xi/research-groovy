def a = true
def b = false

assert a | b
assert a.or(b)
assert !(a & b)
assert !(a.and(b))

def x = 100
def y = 10

assert x + y == 110
assert x.plus(y) == 110

assert ++x == 101
assert x.next() == 102

assert --y == 9
assert y.previous() == 8
