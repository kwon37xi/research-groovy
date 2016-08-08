package builders

import groovy.json.JsonBuilder


class JsonBuilderExample {
    static void main(String[] args) {
        def builder = new JsonBuilder()

        def root = builder.students {
            student {
                studentname 'Joe'
                studentid '1'

                Marks(
                        Subject1: 10,
                        Subject2: 20,
                        Subject3: 30

                )
            }
        }

        println(builder.toPrettyString())

        def seqBuilder = new JsonBuilder()
        seqBuilder([1, 2, 3])
        println(seqBuilder.toPrettyString())

        def classBuilder = new JsonBuilder()

        def students = [new Student(name: 'Joe'), new Student(name: 'Mark'), new Student(name: 'John')]
        builder students, { Student student -> name student.name}
        println(builder.toPrettyString())

    }

    static class Student {
        String name
    }
}
