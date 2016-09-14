def map = [
        accept: {  file ->
            file.path ==~ /.*\.(css|png)$/
        }
] as FileFilter

new File('/project/resources/bower_components/jquery-ui/themes/sunny').listFiles(map).each {
    println it.path
}

// 단일 메소드 인터페이스는 Closure를 사용하면 된다.

def filter = { it.path ==~ /.*\.gradle$/ }
new File('/home/kwon37xi/projects/underscore-builder')
        .listFiles(filter as FileFilter)
        .each { file ->
            println file.path
        }