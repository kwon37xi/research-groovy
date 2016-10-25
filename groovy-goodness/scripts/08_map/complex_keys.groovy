def key = 100

def m = [
        (new Date(109, 11, 1)): 'date key',
        (-42)                 : 'negative number key',
        (false)               : 'boolean key',
        (key)                 : 'variable key'
]


m.(true) = 'boolean key'

m.(2 + 2) = 'number key'
m[(key + 1)] = 'number key'

assert 'date key' == m[new Date(109, 11, 1)]
assert 'negative number key' == m.get(-42)
assert 'boolean key' == m[false]
assert 'variable key' == m[key]
assert 'variable key' == m[100]

assert 'boolean key' == m['true']
assert 'number key' == m.'4' // (2 + 2)
assert 'number key' == m.get(101)