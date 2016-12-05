// script에 import 문 없이 import를 해줄 수 있다.
// ImportCustomizer.addImport -> CompilerConfiguration 에 추가

import org.codehaus.groovy.control.customizers.ImportCustomizer
import org.codehaus.groovy.control.CompilerConfiguration

def importCustomizer = new ImportCustomizer()
importCustomizer.addStaticStars('com.mrhaki.blog.Type')
importCustomizer.addImport('Article', 'com.mrhaki.blog.Post')

def configuration = new CompilerConfiguration()
configuration.addCompilationCustomizers(importCustomizer)

def shell = new GroovyShell(configuration)
shell.evaluate(new File('import_sample.groovy'))