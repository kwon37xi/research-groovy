// SecureASTCustomizer : groovy script 문법에 제약을 가할 수 있음.
// StatementChecker, ExpressionChecker 를 구현하여 제약을 미세 조정가능.

import org.codehaus.groovy.control.customizers.SecureASTCustomizer
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.ast.stmt.*
import org.codehaus.groovy.ast.expr.*
import org.codehaus.groovy.control.MultipleCompilationErrorsException
import static org.codehaus.groovy.syntax.Types.PLUS
import static org.codehaus.groovy.syntax.Types.MINUS
import static org.codehaus.groovy.syntax.Types.EQUAL

final SecureASTCustomizer astCustomizer = new SecureASTCustomizer(
        methodDefinitionAllowed: false,
        closuresAllowed: false,
        packageAllowed: false,
        importsBlacklist: ['java.util.Date'], // or importsWhitelist
        staticImportsWhitelist: [], // or staticImportsBlackList
        staticStarImportsWhitelist: [], // or staticStarImportsBlacklist
        indirectImportCheckEnabled: true,
        tokensWhitelist: [PLUS, MINUS, EQUAL], // or tokensBlacklist
        constantTypesClassesWhiteList: [Integer, Object, String], // constantTypesWhiteList, receiversWhiteList, receiversClassesBlackList, receiversBlackList
        // 특정 언어 구문 무시
        statementsBlacklist: [IfStatement], // statementsWhitelist
        // 특정 언어 표현 무시
        expressionsBlacklist: [MethodCallExpression] // expressionWhitelist
)

final conf = new CompilerConfiguration()
conf.addCompilationCustomizers(astCustomizer)

final shell = new GroovyShell(conf)
final result = shell.evaluate '''
    def s1 = 'Groovy'
    def s2 = 'rocks'
    "$s1 $s2!"
'''
assert result == 'Groovy rocks!'

try {
// importing java.util.Date not allowed
    shell.evaluate '''
        new Date()
    '''
    assert false
} catch (MultipleCompilationErrorsException e) {
    println e.message
    assert e.message.contains('Indirect import checks prevents usage of expressio')
}

try {
// MethodCallExpression not allowed
    shell.evaluate '''
        println 'Groovy rocks!'
    '''
    assert false
} catch (MultipleCompilationErrorsException e) {
    println e.message
    assert e.message.contains('MethodCallExpressions are not allowed: this.println(Groovy rocks!)')
}