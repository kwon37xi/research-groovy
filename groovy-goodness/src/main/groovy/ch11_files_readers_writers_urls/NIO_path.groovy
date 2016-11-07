// java.nio.file.Path 에 대해 Groovy 2.3 부터 메소드들 추가됨.

import java.nio.file.*

final Path newFile = Paths.get('output.txt')
if (Files.exists(newFile)) {
    Files.delete(newFile)
}

// write() 는 기존 내용을 덮어쓴다.
newFile.write 'START'
newFile << System.lineSeparator()
newFile << 'Just a line of text'
newFile.withWriterAppend { writer ->
    writer.println()
    writer.println 'END'
}

final Path readFile = Paths.get('output.txt')

assert readFile.readLines().join(';') == 'START;Just a line of text;END'
assert readFile.filterLine { String line -> line.contains('text') }.toString().normalize() == 'Just a line of text\n'

// Path.eachFile,eachDir,eachFileRecursive,...
final Path root = Paths.get('.')
def paths = root.eachFileMatch(~/.*\.txt$/) { Path path ->
    assert path.toFile().name == 'output.txt'
}

Files.delete(newFile)