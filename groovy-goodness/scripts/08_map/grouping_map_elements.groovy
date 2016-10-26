// groupEntriesBy() : key - List<Map$Entry> 쌍의 새로운 Map 생성.

def m = [q1: 'Groovy', sort: 'desc', q2: 'Grails']

// Closure we use to define the grouping.
// We want all keys starting with 'q' grouped together
// with the key 'params', all other keys are not grouped

def groupIt = { key, value ->
    if (key.startsWith('q')) {
        'params'
    } else {
        key
    }
}

def groupEntries = m.groupEntriesBy(groupIt)
assert 2 == groupEntries.size()
assert groupEntries.params
assert groupEntries.sort
assert 'desc' == groupEntries.sort[0].value
assert 2 == groupEntries.params.size
assert 'Groovy' == groupEntries.params[0].value
assert 'q1' == groupEntries.params[0].key
assert 'Grails' == groupEntries.params.find { it.key == 'q2' }.value
assert groupEntries.params instanceof ArrayList
assert groupEntries.params[0] instanceof Map$Entry

// Use groupBy. Map<String,Map<String, Object>> 로 생성.
def group = m.groupBy(groupIt)
assert 2 == group.size()
assert group.params
assert group.sort

// Key for Map with key/value pairs
assert 'desc' == group.sort.sort
assert 2 == group.params.size()
assert 'Groovy' == group.params.q1
assert 'q1' == group.params.keySet().toArray()[0]
assert 'Grails' == group.params.q2
assert group.params instanceof Map
assert group.params.q1 instanceof String
