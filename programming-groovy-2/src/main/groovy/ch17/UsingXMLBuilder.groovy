import groovy.xml.MarkupBuilder

builder = new MarkupBuilder()
builder.languages {
    language(name: 'C++') {
        author('Stroustrup')
    }
    language(name: 'Java') {
        author('Gosling')
    }
    language(name: 'Lisp') {
        author('McCarthy')
    }

}
