def list = [3, 20, 10, 2, 1]
assert list.indexed() == [0: 3, 1: 20, 2: 10, 3: 2, 4: 1] // 인덱스 번호를 key로 컬렉션 값을 값으로한 Map

def alphabet = 'a'..'z'
def alphabetIndices = alphabet.indexed(1) // 인덱스 번호 1부터 시작
println alphabetIndices // [1:a, 2:b, 3:c, 4:d, 5:e, 6:f, 7:g, 8:h, 9:i, 10:j, 11:k, 12:l, 13:m, 14:n, 15:o, 16:p, 17:q, 18:r, 19:s, 20:t, 21:u, 22:v, 23:w, 24:x, 25:y, 26:z]
assert alphabetIndices.findAll { key, value -> key < 4 } == [1: 'a', 2: 'b', 3: 'c']

def positionInAlphabet = 'groovy'.inject([]) { result, value ->
    result << alphabetIndices.find { it.value == value }.key
    result
}

assert positionInAlphabet == [7, 18, 15, 15, 22, 25]