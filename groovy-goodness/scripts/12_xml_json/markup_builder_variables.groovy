
// MarkupBuilder에서 요소명, 속성명 등을 변수로 지정가능한가?

import groovy.xml.*

def writer = new StringWriter()

def mb = new MarkupBuilder(writer)

String element = "greeting"
String attr = "lang"

mb.xml {
    "$element"("$attr": "kr")
    "$element"("$attr": "en")
}

println writer.toString()