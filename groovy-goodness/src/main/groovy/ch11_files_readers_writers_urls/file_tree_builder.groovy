// 먼저 /tmp/tree 디렉토리가 존재해야한다.

final FileTreeBuilder treeBuilder = new FileTreeBuilder(new File('/tmp/tree'))

treeBuilder.file('README.adoc') {
    write '''= Groovy rocks!
    
    Hidden features in Groovy are also cool.
    
'''.stripIndent()
}

treeBuilder.file('README.adoc', '== Extra heading')

final File sample = new File('/tmp/sample')
sample.text = '''= Another sample

Testing the Groovy FileTreeBuilder

Files,Readers,Writers and URLs

'''

treeBuilder.file('README1.adoc', sample)

treeBuilder.dir('out')

treeBuilder.dir('src') {
    dir('docs') {
        file('manuscript.adoc') {
            withWriter('UTF-8') { writer ->
                writer.write '= Building Apps with Grails 3'
            }
        }
    }
}

assert new File('/tmp/tree/README.adoc').exists()
assert new File('/tmp/tree/src/docs/manuscript.adoc').exists()
assert new File('/tmp/tree/src/docs/manuscript.adoc').text == '= Building Apps with Grails 3'

// FileTreeBuilder 더 간단한 DSL 버전
// 인자로 closure를 받는 메소드는 디렉토리로 친다.
// 인자로 File 객체나 컨텐츠를 받으면 파일이다.
// FTB 는 항상 컨텐츠를 append 하므로, 그게 싫으면 기존 파일이 존재하는지를 검사해서 삭제하고 할 것.

final File newDir = new File('/tmp/dsl')

if (newDir.exists()) {
    newDir.deleteDir()
}

newDir.mkdirs()
final FileTreeBuilder dir = new FileTreeBuilder(newDir)

dir {
    'README.adoc'('''\
= Groovy rocks!

Hidden features in Groovy are also cool.
'''.stripIndent())

    'README.adoc'('=== Extra heading')

    'README1.adoc'(sample)

}

dir.out {}

dir.src {
    docs {
        'manuscript.adoc'('= Building Apps With Grails 3')
    }
}

assert new File('/tmp/dsl/README.adoc').exists()
assert new File('/tmp/dsl/src/docs/manuscript.adoc').exists()
assert new File('/tmp/dsl/src/docs/manuscript.adoc').text == '= Building Apps With Grails 3'