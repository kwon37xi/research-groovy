package json

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.transform.Immutable


class JsonOutputExample {
    static void main(String[] args) {
        def output = JsonOutput.toJson([name: 'John', ID: 1])
        println(output)

        def studentOutput = JsonOutput.toJson([new Student('John', 1), new Student('Mark', 2)])
        println(studentOutput)

        JsonSlurper jsonSlurper = new JsonSlurper()
        List<Student> students = jsonSlurper.parseText(studentOutput)
        println(students)
    }

    @Immutable
    static class Student {
        String name
        int id
    }
}
