import groovy.xml.MarkupBuilder

def body(value) {
    println "body contents is $value"
}

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
builder.message {
    body { // body(value) 메소드를 호출해버림.
        text 'Simple message'
    }
}

def contents = writer.toString()
println '-' * 20
println contents