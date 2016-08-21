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