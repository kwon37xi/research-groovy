def words = ['Groovy', 'Rocks', 'Big', 'Time']

def result = words.collectEntries {
    [(it): it.contains('o')] // [key: value]
}

assert result.Groovy && result.Rocks
assert !result.Big && !result.time
