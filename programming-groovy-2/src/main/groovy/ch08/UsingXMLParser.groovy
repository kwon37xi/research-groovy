package ch08

/*
XmlParser 단점
- XML InfoSet 을 처리할 수 없다.
- XML comments와 Processing Instruction 을 무시한다.
 */
languages = new XmlParser().parse('languages.xml')

println "Languages and authors"

languages.each {
    println "${it.@name} authored by ${it.author[0].text()}"
}

def languagesByAuthor = { authorName ->
    languages.findAll {
        it.author[0].text() == authorName
    }.collect {
        it.@name
    }.join(', ')
}

println "Languages by Wirth: " + languagesByAuthor('Wirth')