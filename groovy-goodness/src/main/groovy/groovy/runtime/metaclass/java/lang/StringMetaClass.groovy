package groovy.runtime.metaclass.java.lang

class StringMetaClass extends DelegatingMetaClass {

    StringMetaClass(MetaClass metaClass) {
        super(metaClass)
    }

    Object invokeMethod(Object object, String method, Object[] arguments) {
        if (method == 'hasGroovy') {
            object ==~ /.*[Gg]roovy.*/
        } else {
            super.invokeMethod object, method, arguments
        }
    }
}
