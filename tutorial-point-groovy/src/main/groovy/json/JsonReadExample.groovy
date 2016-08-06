package json

import groovy.json.JsonSlurper

class JsonReadExample {
    static void main(String[] args) {
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText('''{ "name":"John", "ID":"1" }''')

        println(object.name)
        println(object.ID)

        def list = jsonSlurper.parseText("""{ "List": [2, 3, 4, 5] }""")
        println(list)

        def primitives = jsonSlurper.parseText(''' {"Integer": 12, "fraction": 12.55, "double": 12e13}''')
        println(primitives.Integer)
        println(primitives.fraction)
        println(primitives.double)

    }
}
