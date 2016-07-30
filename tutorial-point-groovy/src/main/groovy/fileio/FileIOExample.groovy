package fileio


class FileIOExample {
    static void main(String[] args) {
        new File("anne.txt").eachLine { line ->
            println("line : " + line)
        }

        File anne = new File("anne.txt")
        println("anne : " + anne.text) // 전체 내용 문자열

        new File("/tmp", "groovy-tutorial.txt").withWriter("UTF-8") { writer ->
            writer.writeLine("Hello World")
        }

        println "The file ${anne.absolutePath} has ${anne.length()} bytes"

        new File("/tmp", "groovy-tutorial.txt").delete()

        def src = new File("anne.txt")
        def dest = new File("/tmp", "anne-copy.txt")
        dest << src.text // copy

        new File(".").eachFile {
            file -> println file.getAbsoluteFile()
        }

        new File(".").eachFileRecurse {
            file -> println file.getAbsolutePath()
        }
    }
}
