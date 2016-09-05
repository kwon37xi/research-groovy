package ch16

import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

import static groovyjarjarasm.asm.Opcodes.ACC_PUBLIC
import static groovyjarjarasm.asm.Opcodes.ACC_STATIC

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class EAMTransformation implements ASTTransformation {
    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        astNodes.findAll { node ->
            node instanceof ClassNode
        }.each { classNode ->
            def useMethodBody = new AstBuilder().buildFromCode {
                def instance = newInstance()
                try {
                    instance.open()
                    instance.with block
                } finally {
                    instance.close()
                }
            }
            def useMethod = new MethodNode('use', ACC_PUBLIC | ACC_STATIC, ClassHelper.OBJECT_TYPE, [new Parameter(ClassHelper.OBJECT_TYPE, 'block')] as Parameter[], [] as ClassNode[], useMethodBody[0])
            classNode.addMethod(useMethod)
        }
    }
}
