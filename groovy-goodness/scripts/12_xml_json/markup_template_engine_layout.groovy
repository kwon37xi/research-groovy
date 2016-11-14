import groovy.text.*
import groovy.text.markup.*

TemplateConfiguration config = new TemplateConfiguration()
MarkupTemplateEngine engine = new MarkupTemplateEngine(config)

// contents 는 클로저를 인자로 받는 메소드로, 레이아웃에 값을 넣을 수 있음.
// layout 에 템플릿 모델 프라퍼티(pubDate)를 넘기려면 layout 두 번째 인자를 true로 줘야함.
Template template = engine.createTemplate('''
layout 'main.tpl', true,
    pageTitle: 'Welcome',
    mainContents: contents {
        h1 'Home'
    },
    actions: contents {
        ul(class: 'actions') {
            ['Home', 'About'].each { li it }
        }
    }
''')

Writer writer = new StringWriter()
Writable output = template.make(pubDate: Date.parse('yyyyMMdd', '20140801'))
//Writable output = template.make([:])
output.writeTo(writer)
String result = writer.toString()

println result
assert result == "<html><head><title>Welcome</title></head>\
<body>\
<section id='main'><h1>Home</h1></section>\
<section id='actions'><ul class='actions'><li>Home</li><li>About</li></ul></section>\
<footer><p>Generated on 01-08-2014</p></footer>\
</body></html>"