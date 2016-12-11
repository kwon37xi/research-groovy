import org.codehaus.groovy.control.customizers.SecureASTCustomizer
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.ast.stmt.*
import org.codehaus.groovy.ast.expr.*
import org.codehaus.groovy.control.MultipleCompilationErrorsException
import static org.codehaus.groovy.control.customizers.SecureASTCustomizer.ExpressionChecker
import static org.codehaus.groovy.control.customizers.SecureASTCustomizer.StatementChecker

final SecureASTCustomizer astCustomizer = new SecureASTCustomizer()

// 길이 1인 변수명 거부
def smallVariableNames = { expr ->
    if (expr instanceof VariableExpression) {
        expr.variable.size() > 1
    } else {
        true
    }
} as ExpressionChecker

astCustomizer.addExpressionCheckers(smallVariableNames)

// for loop에서 컬렉션 이름은 무조건 'names'
def forCollectionNames = { statement ->
    if (statement instanceof ForStatement) {
        statement.collectionExpression.variable == 'names'
    } else {
        true
    }
} as StatementChecker

astCustomizer.addStatementCheckers(forCollectionNames)

final CompilerConfiguration conf = new CompilerConfiguration()
conf.addCompilationCustomizers(astCustomizer)

final GroovyShell shell = new GroovyShell(conf)

final result = shell.evaluate '''
def names = ['Groovy', 'Grails']
for (name in names) {
    println "$name rocks! "
}

def s1 = 'Groovy\'
def s2 = 'rocks\'
"$s1 $s2!"
'''

assert result == 'Groovy rocks!'

try {
    shell.evaluate '''
        def s = 'Groovy rocks'
        s
    '''
    assert false
} catch (MultipleCompilationErrorsException e) {
    assert e.message.contains('Expression [VariableExpression] is not allowed: s')
}

try {
    shell.evaluate '''
        def languages = ['Groovy', 'Grails']
        for (name in languages) {
            println "$name rocks!"
        }
    '''
    assert false
} catch (MultipleCompilationErrorsException e) {
    assert e.message.contains('Statement [ForStatement] is not allowed')
}

