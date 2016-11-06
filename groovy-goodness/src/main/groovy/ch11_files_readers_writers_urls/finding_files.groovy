// FileNameFinder : ANT fileset pattern
// FileNameByRegExFinder : regular expression pattern

//def groovyHome = System.getenv('GROOVY_HOME')
def groovyHome = '/home/kwon37xi/.sdkman/candidates/groovy/current'

// home, include pattern, exclude pattern
def textFiles = new FileNameFinder().getFileNames(groovyHome, '**/*.txt', '**/*.doc **/*.pdf')
assert new File(groovyHome, 'licenses/asm-license.txt').absolutePath in textFiles

def icoFiles = new FileNameByRegexFinder().getFileNames(groovyHome, /.*\.conf/)
assert new File(groovyHome, 'conf/groovy-starter.conf').absolutePath in icoFiles