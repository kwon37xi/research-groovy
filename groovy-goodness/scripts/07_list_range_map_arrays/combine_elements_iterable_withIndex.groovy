// withIndex -> List of tuples
// indexed() : Map key : index value, value : iterable value

def list = [3, 20, 10, 2, 1]

// 각 값과 그 인덱스를 튜플을 가진 리스트
assert list.withIndex() == [[3, 0], [20, 1], [10, 2], [2, 3], [1, 4]]

def alphabet = 'a'..'z'

def alphabetIndices = alphabet.withIndex(1) // 인덱스가 1부터 시작.
println alphabetIndices // [[a, 1], [b, 2], [c, 3], [d, 4], [e, 5], [f, 6], [g, 7], [h, 8], [i, 9], [j, 10], [k, 11], [l, 12], [m, 13], [n, 14], [o, 15], [p, 16], [q, 17], [r, 18], [s, 19], [t, 20], [u, 21], [v, 22], [w, 23], [x, 24], [y, 25], [z, 26]]

assert alphabetIndices[0..2] == [['a', 1], ['b', 2], ['c', 3]]

def positionInAlphabet = 'groovy'.inject([]) { result, value ->
    result << alphabetIndices.find { it[0] == value }[1]
    result
}

assert positionInAlphabet == [7, 18, 15, 15, 22, 25]
