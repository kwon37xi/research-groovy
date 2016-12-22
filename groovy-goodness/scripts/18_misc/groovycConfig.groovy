import groovy.transform.CompileStatic
import groovy.transform.ToString
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer
import org.codehaus.groovy.control.customizers.ImportCustomizer
import org.codehaus.groovy.control.customizers.SecureASTCustomizer

configuration.addCompilationCustomizers(
        new ASTTransformationCustomizer(CompileStatic))
configuration.addCompilationCustomizers(
        new ASTTransformationCustomizer(ToString)
)

def imports = new ImportCustomizer()
imports.addStarImports('java.time')
configuration.addCompilationCustomizers(imports)

def smallVariableNames = { expr ->
    if (expr instanceof VariableExpression) {
        expr.variable.size() > 1
    } else {
        true
    }
} as SecureASTCustomizer.ExpressionChecker

def secureAstCustomizer = new SecureASTCustomizer()
secureAstCustomizer.addExpressionCheckers(smallVariableNames)
configuration.addCompilationCustomizers(secureAstCustomizer)
