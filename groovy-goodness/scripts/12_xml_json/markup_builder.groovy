// MarkupBuilder : 간단한거
// StreamingMarkupBuilder : namespace 등이 있는 복잡한거
import groovy.xml.*

def writer = new StringWriter()
def html = new MarkupBuilder(writer)
html.html {
    head {
        title 'Simple Document'
    }
    body(id: 'main') {
        h1 'Building HTML the Groovy Way'
        p {
            mkp.yield 'Mixing text with '
            strong 'bold'
            mkp.yield ' elements'
        }
        a href: 'more.html', 'Read more...'
    }
}


println writer.toString()

def builder = new StreamingMarkupBuilder()
builder.encoding = 'UTF-8'
def books = builder.bind {
    mkp.xmlDeclaration()
    namespaces << [meta: 'http://meta/book/info'] // or mkp.declareNamespace('meta': '....')
    books(count: 3) {
        book(id: 1) {
            title lang: 'en', 'Groovy in Action'
            meta.isbn '1-932394-84-2'
        }
        book(id: 2) {
            title lang: 'en', 'Groovy Programming'
            meta.isbn '0123725070'
        }
        book(id: 3) {
            title 'Groovy & Grails'
            comment << 'Not yet available.' // mkp.comment('Not yet available')
        }
        book(id: 4) {
            mkp.yieldUnescaped '<title>Griffon Guide</title>'
        }
    }
}

println XmlUtil.serialize(books)