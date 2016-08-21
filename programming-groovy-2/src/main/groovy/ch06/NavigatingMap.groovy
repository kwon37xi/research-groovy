package ch06

langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

langs.each { entry -> // java.util.LinkedHashMap$Entry
    println "Language $entry.key was authored by $entry.value"
}

langs.each { language, author ->
    println "[key/value] Language $language was authored by $author"
}

println langs.collect { language, author ->
    language.replaceAll("[+]", "P")
} // Map -(collect)-> List

println "Looking for the first language with name greater than 3 characters"
entry = langs.find { language, author ->
    language.size() > 3
} // 결과값은 Entry

println "Found $entry.key written by $entry.value"

println "Looking for all languages with name greater than 3 characters"
selected = langs.findAll { language, author ->
    language.size() > 3
}
selected.each { key, value ->
    println "Found $key written by $value"
}

print "Does any language name have a nonalphabetic character? "
println langs.any { language, author -> language =~ "[^A-Za-z]" }

print "Do all language names have a nonaphabetic character? "
println langs.every { language, author -> language =~ "[^A-Za-z]"}

friends = [
        briang: 'Brian Goetz',
        brians: 'Brian Sletten',
        davidb: 'David Bock',
        dividg: 'David Geary',
        scottd: 'Scott Davis',
        scottl: 'Scott Leberknight',
        suarth: 'Stuart halloway'
]

groupByFirstName = friends.groupBy {
    it.value.split(' ')[0]
} // 새로운 맵이 생긴다. Map key -> firstname, Map value -> 이름

groupByFirstName.each { firstName, buddies -> // key , value
    println "$firstName : ${buddies.collect { key, fullName -> fullName }.join(', ')}"
}