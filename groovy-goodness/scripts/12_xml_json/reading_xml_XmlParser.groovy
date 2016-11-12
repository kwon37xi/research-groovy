// XmlParser : List of NodeList and Node

import groovy.xml.*

def xml = '''
<books xmlns:meta="http://meta/book/info" count="3">
    <book id="1">
        <title lang="en">Groovy in Action</title>
        <meta:isbn>1-932394-84-2</meta:isbn>
    </book>
    <book id="2">
        <title lang="en">Groovy Programming</title>
        <meta:isbn>0123725070</meta:isbn>
    </book>
    <book id="3">
        <title>Groovy &amp; Grails</title>
        <!-- Not yet available. -->
    </book>
    <book id="4">
        <title>Griffon Guide</title>
    </book>
</books>
'''


def ns = new Namespace('http://meta/book/info', 'meta')
def books = new XmlParser().parseText(xml)
assert books instanceof Node
assert 4 == books.book.size()
assert 11 == books.breadthFirst().size()
assert 'Groovy in Action' == books.book[0].title.text()

// '@id' == attribute('id')
assert 'Groovy Programming' == books.book.find { it.'@id' == '2'}.title.text()
assert 'Groovy Programming' == books.book.find { it.attribute('id') == '2'}.title.text()

assert [1, 2, 3] == books.book.findAll {
    it.title.text() =~ /Groovy/
}.'@id'*.toInteger()

assert ['1-932394-84-2', '0123725070'] == books.book[ns.isbn].inject([]) { result, v ->
    result << v.text()
}

