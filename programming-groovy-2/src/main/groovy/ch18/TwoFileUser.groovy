package ch18


class TwoFileUser {
    def useFiles(str) {
        def file1 = new FileWriter("output1.txt")
        def file2 = new FileWriter("output2.txt")

        file1.write str
        file2.write str.size()
        file1.close()
        file2.close()
    }

    def someWriter() {
        def file = new FileWriter('output.txt')
        file.write("one")
        file.write("two")
        file.write(3)
        file.flush()
        file.write(file.getEncoding())
        file.close()
    }
}
