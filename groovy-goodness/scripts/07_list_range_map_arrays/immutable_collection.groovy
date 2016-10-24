// Collection.asImmutable()

def list = ['Groovy', 'Java', 'JRuby'].asImmutable()
assert 'Groovy' == list[0]

try {
    list << 'Scala'
} catch (e) {
    assert e instanceof UnsupportedOperationException
}

try {
    list.remove 'Java'
} catch (e) {
    assert e instanceof UnsupportedOperationException
}

def map = [name: 'mrhaki', country: 'Holland', blog: true].asImmutable()
assert map.blog

try {
    map.blog = false
} catch (e) {
    assert e instanceof UnsupportedOperationException
}
