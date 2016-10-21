// collate : 대조하다. 맞춰보다. -> List를 partitioning 하는 역할.

def letters = 'a'..'g'

assert letters.collate(3) == [['a', 'b', 'c'], ['d', 'e', 'f'], ['g']]

// 2 steps
assert letters.collate(3, 2) == [
        ['a', 'b', 'c'],
        ['c', 'd', 'e'],
        ['e', 'f', 'g'],
        ['g']
]

// Don't include remainder in result,
// Default a remainder is included in the result
boolean remainder = false
assert letters.collate(3, remainder) == [['a', 'b', 'c'], ['d', 'e', 'f']]
assert letters.collate(3, 2, remainder) == [
        ['a', 'b', 'c'],
        ['c', 'd', 'e'],
        ['e', 'f', 'g']
]