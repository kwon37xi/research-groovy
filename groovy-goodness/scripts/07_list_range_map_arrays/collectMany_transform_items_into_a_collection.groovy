// collectMany closure에서 컬렉션을 리턴하지면 이 모든 결과가 하나의 컬렉션으로 펼쳐짐(flatten)

def text = 'groovy' as String[]

def mixedCase = text.collectMany { [it, it.toUpperCase()] }
assert mixedCase == ['g', 'G', 'r', 'R', 'o', 'O', 'o', 'O', 'v', 'V', 'y', 'Y']
assert text == 'groovy' as String[] // 원본 값은 변형하지 않음.

def list = [12, 20, 34]
def result = list.collectMany { [it, it * 2, it * 3] }
assert result == [12, 24, 36, 20, 40, 60, 34, 68, 102]
assert list == [12, 20, 34]