def m = [user: 'mrhaki', likes: 'Groovy']
def sentence = m.inject('Message: ') { s, k, v -> // 초기값, key, value
    s += "${k == 'likes' ? 'loves' : k} $v "
}

println sentence
assert sentence.trim() == 'Message: user mrhaki loves Groovy'

// 2-argument closure with entry
def map = [sort: 'name', order: 'desc']
def equalSizeKeyValue = map.inject([]) { list, entry ->
    list << (entry.key.size() == entry.value.size())
}

assert equalSizeKeyValue == [true, false]