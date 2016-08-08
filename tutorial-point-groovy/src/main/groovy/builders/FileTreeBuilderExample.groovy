package builders


class FileTreeBuilderExample {
    static void main(String[] args) {
        def tmpDir = File.createTempDir()
        def fileTreeBuilder = new FileTreeBuilder(tmpDir)

        fileTreeBuilder.dir('main') {
            dir('submain') {
                dir('tutorial') {
                    file('Sample.txt', 'println "Hello World"')
                }
            }
        }

        println tmpDir
    }
}
