def methods = ['min', 'max', 'sum']
def classes = ['Object[]', 'Collection']

def combinations = GroovyCollections.combinations([classes, methods])
assert 2 * 3 == combinations.size()
println combinations
assert [['Object[]', 'min'], ['Collection', 'min'], ['Object[]', 'max'], ['Collection', 'max'], ['Object[]', 'sum'], ['Collection', 'sum']]

assert 3 == combinations.findAll { it[0] == 'Collection' }.size()

def keys = ['username', 'email']
def values = ['mrhaki', 'email@host.com', 'not-transposed']
def transpose = GroovyCollections.transpose([keys, values, [0, 1]]) // 이항하다. 바꾸어놓다.
assert 2 == transpose.size() // transpose는 갯수가 가장 적은 것에 맞춰서 짝을 맞추고 남는 것은 버리는듯.
println transpose

assert [['username', 'mrhaki', 0], ['email', 'email@host.com', 1]] == transpose