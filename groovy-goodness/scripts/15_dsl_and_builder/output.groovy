console 'Groovy is great'

file('/tmp/result.txt') { out ->
    out << 'Yes it is!'
}
