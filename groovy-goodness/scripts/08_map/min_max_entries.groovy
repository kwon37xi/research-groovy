// min(), max()

def money = [cents: 5, dime: 2, quarter: 3]

assert money.max { it.value }.value == 5 // Comparable 구현한 value를 정렬기준으로 삼아서 max 구함.
assert money.max { it.key }.key == 'quarter'

// Entry 두개를 받아서 비교
assert money.max { a, b ->
    a.key.size() <=> b.key.size()
}.key == 'quarter'

assert money.min { it.value }.value == 2
assert money.min { it.key }.key == 'cents'

assert money.min { a, b ->
    a.key.size() <=> b.key.size()
}.key == 'dime'