import groovy.io.FileType

(1..3).each {
    new File("/tmp/groovybase/dir$it").mkdirs()
}

(1..3).each {
    def file = new File("/tmp/groovybase/file$it")
    file << "Sample content for ${file.absolutePath}"
}

def currentDir = new File('/tmp/groovybase')
def dirs = []
currentDir.eachFile FileType.DIRECTORIES, {
    dirs << it.name
}
dirs.sort() // 순서가 뒤죽박죽이라 이름순 정렬.
assert 'dir1,dir2,dir3' == dirs.join(',')

def files = []
currentDir.eachFile(FileType.FILES) {
    files << it.name
}
files.sort()
assert 'file1,file2,file3' == files.join(',')

def found = []
currentDir.eachFileMatch(FileType.ANY, ~/.*2/) {
    found << it.name
}
assert 'dir2,file2' == found.join(',')