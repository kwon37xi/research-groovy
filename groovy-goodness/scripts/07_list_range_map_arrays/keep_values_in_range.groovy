// range : list with sequential values.
// range는 List이기도 하다. Range extends java.util.List
// 1..10 : inclusive
// 1..<10 : exclusive

// Comparable, next(), previous() 를 구현한 객체는 range로 사용될 수 있다.

def ints = 1..10
assert [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] == ints

assert 10 == ints.size()
assert 1 == ints.from
assert 10 == ints.to

def list = []
ints.step(2) { list << it }
assert [1, 3, 5, 7, 9] == list

assert 1 == ints[0]
assert 10 == ints.last()

def s = ''
(2..4).each { s += it }
assert '234' == s

// exclusive range
def exclusive = 2..<8
assert [2, 3, 4, 5, 6, 7] == exclusive
assert 6 == exclusive.size()
assert !exclusive.contains(8)

// Object with next() and previous() can be used in range.
// Groovy extends Java enum with next() and previous()

enum Compass {
    NORTH, NORTH_EAST, EAST, SOUTH_EAST,
    SOUTH, SOUTH_WEST, WEST, NORTH_WEST
}

def northToSouth = Compass.NORTH..Compass.SOUTH
assert 5 == northToSouth.size()
assert Compass.EAST == northToSouth[2]


// next() -> ++
// previous() -> --

def region = Compass.SOUTH
assert Compass.SOUTH_WEST == ++region
assert Compass.SOUTH == --region
