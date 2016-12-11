// Groovy 2.1 CompileConfiguration 을 CompilerCustomizationBuilder.withConfig
// 여러 커스터마이저 등록 ImportCustomizer, SecureASTCustomizer ASTTransformationCustomizer

import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.builder.CompilerCustomizationBuilder
import groovy.transform.*

def conf = new CompilerConfiguration()

CompilerCustomizationBuilder.withConfig(conf) {
    ast(TupleConstructor)
    ast(ToString, includeNames: true, includePackage: false)

    imports {
        alias 'Inet', 'java.net.URL'
    }

    secureAst {
        methodDefinitionAllowed = true // true 여야 컴파일됨.
    }
}

def shell = new GroovyShell(conf)
shell.evaluate '''
package com.mrhaki.blog

class User {
    String username, fullname
}

// TupleConstructor
def user = new User('mrhaki', 'Hubert A. Klein Ikkink')
// @ToString
assert user.toString() == 'User(username:mrhaki, fullname:Hubert A. Klein Ikkink)'

// import alias
def site = new Inet('http://www.mrhaki.com/')
assert site.text
'''