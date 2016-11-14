// MarkupTemplateEngine generates XML/HTML
// compile template for better performance
// type checking
// BaseTemplate

import ch12_xml_json.FontAwesomeTemplate
import groovy.text.markup.*
import groovy.text.*

TemplateConfiguration config = new TemplateConfiguration(baseTemplateClass: FontAwesomeTemplate)

MarkupTemplateEngine engine = new MarkupTemplateEngine(config)

Template template = engine.createTemplate('''
ul {
    li icon('cloud')
    li icon('pencil', 'large', 'rotate-90')
}

// 텍스트 사이에서 icon 메소드를 사용하려면 ${stringOf notation} 으로 감싼다.
p "this is a ${stringOf {icon('home')}} home icon."
p {
    yield 'This is a '
    yieldUnescaped icon('cog')
    yield " settings icon."
}
''')

Writer writer = new StringWriter()
Writable output = template.make([:])
output.writeTo(writer)
String result = writer.toString()
println result

assert result == '<ul><li><span class="fa fa-cloud "></span></li><li><span class="fa fa-pencil fa-large fa-rotate-90"></span></li></ul>\
<p>this is a <span class="fa fa-home "></span> home icon.</p>\
<p>This is a <span class="fa fa-cog "></span> settings icon.</p>'