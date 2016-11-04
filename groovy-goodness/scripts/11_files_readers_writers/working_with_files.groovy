
def file1 = new File('/tmp/groovy1.txt')
def file2 = new File('/tmp/groovy2.txt')
def file3 = new File('/tmp/groovy3.txt')

file1.write 'Working with files the Groovy way is easy.\n'

file1 << 'See how easy it is to add text to a file.\n'

file2.text = '''We can even use the text property of
a file to set a complete block of text at once.'''

file3.withWriter('UTF-8') { writer ->
    writer.write('We can also use writers to add contents')
}

List<String> lines = file1.readLines()
assert 2 == lines.size()
assert 'Working with files the Groovy way is easy.' == lines[0]

assert 'We can also use writers to add contents' == file3.text

count = 0
file2.withReader { reader ->
    while (line = reader.readLine()) {
        switch (count) {
            case 0:
                assert 'We can even use the text property of' == line
                break
            case 1:
                assert 'a file to set a complete block of text at once.' == line
                break
        }
        count++
    }
}

// We can also read contents with a filter:
sw = new StringWriter()
file1.filterLine(sw) { it =~ /Groovy/ } // 매칭되는 라인을 sw 에 넣음.
assert 'Working with files the Groovy way is easy.\n' == sw.toString()

def files = [] as Set
new File('/tmp').eachFileMatch(~/^groovy.*\.txt$/) { files << it.name }
assert files == ['groovy1.txt', 'groovy2.txt', 'groovy3.txt'] as Set

files.each { new File(it).delete()}