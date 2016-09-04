package ch16

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.ast.stmt.Statement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class InjectAudit implements ASTTransformation {

    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        def checkingAccountClassNode = astNodes[0].classes.find {
            it.name == 'CheckingAccount'
        }

        injectAuditMethod(checkingAccountClassNode)
    }

    static void injectAuditMethod(checkingAccountClassNode) {
        def nonAuditMethods = checkingAccountClassNode?.methods.findAll {
            it.name != 'audit'
        }
        nonAuditMethods?.each {
            injectMethodWithAudit(it)
        }
    }

    /*
    static void injectMethodWithAudit(methodNode) {
        def callToAudit = new ExpressionStatement(
                new MethodCallExpression(
                        new VariableExpression('this'),
                        'audit',
                        new ArgumentListExpression(methodNode.parameters)
                )
        )

        // IntelliJ에서 내부적으로 컴파일할 때는 여기서 에러가 났지만
        // groovyc/groovy 로 컴파일 실행할 때문 아무 문제없이 실행됐다.
        methodNode.code.statements.add(0, callToAudit)
    }
    */
    // EasingThePain - using AstBuilder.buildFromSpec
    /*
    static void injectMethodWithAudit(methodNode) {
        List<Statement> statements = new AstBuilder().buildFromSpec {
            expression {
                methodCall {
                    variable 'this'
                    constant 'audit'
                    argumentList {
                        methodNode.parameters.each {
                            variable it.name
                        }
                    }
                }
            }
        }

        def callToCheck = statements[0]
        methodNode.code.statements.add(0, callToCheck)
    }
    */

    /*

    static void injectMethodWithAudit(methodNode) {
        def codeAsString = 'audit(amount)'
        List<Statement> statements = new AstBuilder().buildFromString(codeAsString)

        def callToAudit = statements[0].statements[0].expression
        methodNode.code.statements.add(0, new ExpressionStatement(callToAudit))
    }
     */

    // buildFromCode
    static void injectMethodWithAudit(methodNode) {
        List<Statement> statements = new AstBuilder().buildFromCode {
            audit(amount)
        }

        def callToAudit = statements[0].statements[0].expression
        methodNode.code.statements.add(0, new ExpressionStatement(callToAudit))
    }
}
