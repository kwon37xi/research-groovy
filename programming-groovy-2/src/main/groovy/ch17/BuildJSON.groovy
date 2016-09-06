package ch17

import groovy.json.JsonBuilder

class Person {
    String first
    String last
    def sigs
    def tools
}

john = new Person(first: "John", last: "Smith", sigs: ['Java', 'Groovy'], tools: ['script': 'Groovy', 'test': 'Spock'])
builder = new JsonBuilder(john)
writer = new StringWriter()
builder.writeTo(writer)
println writer


builder = new JsonBuilder()
builder {
    fistName john.first
    lastName john.last
    "special interest groups" john.sigs
    "preferred tools" {
        numberOfTools john.tools.size()
        tools john.tools
    }
}

writer = new StringWriter()
builder.writeTo(writer)
println writer