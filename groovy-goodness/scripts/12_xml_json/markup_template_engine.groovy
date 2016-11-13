// Nested templates with MarkupTemplateEngine
import groovy.text.Template
import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration

TemplateConfiguration config = new TemplateConfiguration(useDoubleQuotes: true, expandEmptyElements: true)

MarkupTemplateEngine engine = new MarkupTemplateEngine(config)

Template template = engine.createTemplate('''
// Nested template to generate
// FontAwesome markup.
// The fragment expect a model attribute
// with the name icon.
def faIcon = 'span(class: "fa fa-${icon}")'

// Netsted template to generate
// a unordered list for given items,
// specified with the items model attribute.
String list = """ul {
    items.each { item ->
        li item
    }
}

// Use fragment method.
fragment
''')