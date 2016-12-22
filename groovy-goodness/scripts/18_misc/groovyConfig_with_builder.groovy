import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.control.customizers.SecureASTCustomizer

// CompilerCustomzationBuilder.withConfig
// CompilerCustomzationBuilder 이미 암시적으로 import 돼 있는 상태

withConfig(configuration) {
    ast(groovy.transform.CompileStatic)
    ast(includeNames:true, groovy.transform.ToString)
    imports {
        start('java.time')
    }

    def smallVariableNames = { expr ->
        if (expr instanceof VariableExpression) {
            expr.variable.size() > 1
        } else {
            true
        }
    } as SecureASTCustomizer.ExpressionChecker
    secureAst {
        addExpressionCheckers smallVariableNames
    }
}
