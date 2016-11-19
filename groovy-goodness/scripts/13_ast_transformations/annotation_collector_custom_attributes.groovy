import org.codehaus.groovy.ast.AnnotatedNode
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.AnnotationCollectorTransform

class SimpleProcessor extends AnnotationCollectorTransform {
    public List<AnnotationNode> visit(AnnotationNode collector, AnnotationNode aliasAnnotationUsage, AnnotatedNode aliasAnnotated, SourceUnit source) {
        def attributes = aliasAnnotationUsage.getMembers()
        def dontUse = attributes.get('dontUse')
        attributes.remove('dontUse')

        if (dontUse) {
            aliasAnnotationUsage.addMember('excludes', dontUse)
        }

        super.visit(collector, aliasAnnotationUsage, aliasAnnotated, source)
    }
}

new GroovyShell(this.class.classLoader).evaluate '''
import groovy.transform.*

@AnnotationCollector(value = [EqualsAndHashCode, ToString], processor = 'SimpleProcessor')
@interface Simple {}

@Simple(dontUse = 'age')
class User {
    String username
    int age
}

def user = new User(username: 'mrhaki', age: 39)
assert user.toString() == 'User(mrhaki)' // no age
'''