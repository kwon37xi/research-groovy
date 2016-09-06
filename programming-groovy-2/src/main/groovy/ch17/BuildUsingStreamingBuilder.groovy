import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

xmlDocument = new StreamingMarkupBuilder().bind {
    mkp.xmlDeclaration()
    mkp.declareNamespace(computer: 'Computer')

    languages {
        comment << 'Created using StreamingMarkupBuilder'
        langs.each { key, value ->
            computer.language(name: key) {
                autor(value)
            }
        }
    }
}
// XmlUtil.serialize를 통해 pretty print 가능
// http://mrhaki.blogspot.kr/2012/10/groovy-goodness-pretty-print-xml.html
println XmlUtil.serialize(xmlDocument)
