// http://melix.github.io/blog/2011/05/12/customizing_groovy_compilation_process.html
// ASTTransformationCustomizer
// 오직 class level Transformation만 가능.
// script 내의 모든 클래스에 적용됨.
// 파라미터 지정 불가.

import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer
import org.codehaus.groovy.control.CompilerConfiguration
import groovy.transform.Canonical

def conf = new CompilerConfiguration()
conf.addCompilationCustomizers(new ASTTransformationCustomizer(Canonical)) // 모든 클래스에 @Canonical 적용, default로 적용.

def shell = new GroovyShell(conf)
shell.evaluate '''
package com.mrhaki.blog

class User {
    String username, fullname
}

def user = new User('mrhaki', 'Hubert A. Klein Ikkink')
assert user.toString() == 'com.mrhaki.blog.User(mrhaki, Hubert A. Klein Ikkink)'
assert this.toString() == 'com.mrhaki.blog.Script1()'
    
'''