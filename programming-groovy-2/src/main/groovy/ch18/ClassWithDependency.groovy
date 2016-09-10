package ch18


class ClassWithDependency {
    def methodA(val, file) {
        file.write "The value is ${val}."
    }

    def methodB(val) {
        def file = new FileWriter("output.txt")
        file.write "The value is ${val}."
    }

    def methodC(val) {
        def file = new FileWriter("output.txt")
        file.write "The value is ${val}."
        file.close()
    }
}
