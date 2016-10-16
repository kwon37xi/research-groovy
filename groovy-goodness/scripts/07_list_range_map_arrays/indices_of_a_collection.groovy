def list = [3, 20, 10, 2, 1]
assert list.indices == 0..4

def alphabet = 'a'..'z'
def alphabetIndices =[alphabet, alphabet.indices].transpose() // 각각을 하나씩 쌍으로 맞춤
println alphabetIndices // [[a, 0], [b, 1], [c, 2], [d, 3], [e, 4], [f, 5], [g, 6], [h, 7], [i, 8], [j, 9], [k, 10], [l, 11], [m, 12], [n, 13], [o, 14], [p, 15], [q, 16], [r, 17], [s, 18], [t, 19], [u, 20], [v, 21], [w, 22], [x, 23], [y, 24], [z, 25]]

// Find position of each letter
// from 'groovy' in a alphabet.
def positionInAlphabet = 'groovy'.inject([]) { result, value ->
    result << alphabetIndices.find { it[0] == value }[1] + 1 // it[0]은 알파벳 부분
    result
}

assert positionInAlphabet == [7, 18, 15, 15, 22, 25]

