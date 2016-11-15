// JsonBuilder 는 메모리에서 JSON생성.
// StreamingJsonBuilder는 Writer로 JSON 를 계속 스트리밍함. 메모리 적게 사용.

import groovy.json.*

def jsonWriter = new StringWriter()
def jsonBuilder = new StreamingJsonBuilder(jsonWriter)

jsonBuilder.message {
    header {
        from(author: 'mrhaki')
        to 'Groovy Users', 'Java Users'
    }
    body "Check out Groovy's gr8 JSON support."
}

def json = jsonWriter.toString()
assert json == '{"message":{"header":{"from":{"author":"mrhaki"},"to":["Groovy Users","Java Users"]},"body":"Check out Groovy\'s gr8 JSON support."}}'

def prettyJson = JsonOutput.prettyPrint(json)
println prettyJson

new StringWriter().withWriter { sw ->
    def builder = new StreamingJsonBuilder(sw)

    builder name: 'Groovy', supports: 'JSON'
    assert sw.toString() == '{"name":"Groovy","supports":"JSON"}'
}

new StringWriter().with { sw ->
    def builder = new StreamingJsonBuilder(sw)

    builder.user(name: 'mrhaki') {
        active true
    }

    assert sw.toString() == '{"user":{"name":"mrhaki","active":true}}'


}