import groovy.xml.MarkupBuilder

langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

writer = new java.io.StringWriter()

// MarkupBuilder는 소규모 XML을 만들때 사용. 메모리가 많이 필요한 대규모 XML은 StreamingMarkupBuilder
builder = new MarkupBuilder(writer)

builder.languages {
    langs.each { key, value ->
        language(name: key) {
            author(value)
        }
    }
}

println "BuildXML========="
println writer
