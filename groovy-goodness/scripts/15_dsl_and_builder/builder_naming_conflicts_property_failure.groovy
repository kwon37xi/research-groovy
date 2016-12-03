import groovy.xml.MarkupBuilder

// 동적으로 name을 사용하는 builder와 로컬 컨텍스트에 존재하는 name이 충돌하는 상황은?

def body = []
def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
builder.message {
    body(contentType: 'plain') {    // 여기서 에러남. Caught: groovy.lang.MissingMethodException: No signature of method: java.util.ArrayList.call() is applicable for argument types: (java.util.LinkedHashMap, builder_naming_conflicts_property_failure$_run_closure1$_closure2) values: [[contentType:plain], builder_naming_conflicts_property_failure$_run_closure1$_closure2@6a400542]
                                    // Possible solutions: tail(), tail(), wait(), last(), last(), any()
        text 'Simple Message'
    }
}

def contents = writer.toString()
println contents

