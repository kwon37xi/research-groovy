def m = [sort: 'asc', name: 'test', paginate: true, max: 1000]

def expectedKeys = ['max', 'name', 'paginate', 'sort']

assert expectedKeys == m.sort()*.key
// or sort by Comparator
assert expectedKeys == m.sort({k1, k2 -> k1 <=> k2 } as Comparator)*.key

// sorting before 1.7.2
assert expectedKeys == new TreeMap(m)*.key

// sort by Closure
assert expectedKeys == m.sort { e1, e2 -> e1.key <=> e2.key }*.key