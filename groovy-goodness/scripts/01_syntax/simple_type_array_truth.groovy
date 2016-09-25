// 원래는 Object[] 만 되던 배열 크기에 따른 true/false가 primitive 타입에도 1.7.4 버전부터 지원됨.

def bytes = [] as byte[]
def ints = [1,2,4] as int[]
def floats = [] as float[]
def booleans = [true, false] as boolean[]

assert !bytes
assert ints
assert !floats
assert booleans


