package ch08

/*
XmlSlurper 는 메모리 소모량이 적다.
- Lazy Evaluation 덕분에 대용량 파일 처리가 가능하다.
- namespace 사용가능하다.
 */

languages = new XmlSlurper().parse("languages.xml")

println "Languages and authors by XmlSlurper"

languages.language.each {
    println "${it.@name} authored by ${it.author[0].text()}"
}

def languagesByAuthor = { authorName ->
    languages.language.findAll {
        it.author[0].text() == authorName
    }.collect {
        it.@name
    }.join(', ')
}