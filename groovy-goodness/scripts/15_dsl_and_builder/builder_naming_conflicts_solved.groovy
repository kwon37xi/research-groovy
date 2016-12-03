// name 충돌 발생시 delegate.name 을 사용하면 무조건 builder 컨텍스트 우선이다.

import groovy.xml.MarkupBuilder

def body = []

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)

builder.message {
    delegate.body(contentType: 'plain') {
        text 'Simple message'
    }
}

def contents = writer.toString()
println contents
//<message>
//<body contentType='plain'>
//<text>Simple message</text>
//  </body>
//</message>