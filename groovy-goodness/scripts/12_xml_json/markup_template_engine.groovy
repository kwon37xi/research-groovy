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
"""

// Use fragment method.
fragment list, items: ['A', 'B', 'C']

ul {
    ['cloud', 'home', 'pencil'].each {  iconValue ->
        // Generate output with predefined
        // fragment faIcon. Pass value for model attribute icon.
        // We must use ${stringO{...}} because we apply
        // the fragment as inline element.
        li "${stringOf {fragment(faIcon, icon:iconValue)}}"
    }
}

// Reuse fragment in other parts of the template.
p "This is a ${stringOf {fragment(faIcon, icon: 'cog')}} settings icon."
''')

Writer writer = new StringWriter()
Writable output = template.make([:])
output.writeTo(writer)
String result = writer.toString()
println result
def expected = $/\
<ul><li>A</li><li>B</li><li>C</li></ul>\
<ul>\
<li><span class="fa fa-cloud"></span></li>\
<li><span class="fa fa-home"></span></li>\
<li><span class="fa fa-pencil"></span></li>\
</ul>\
<p>This is a <span class="fa fa-cog"></span> settings icon.</p>\
/$
assert result == expected