import groovy.transform.Immutable

def printMetaClassInfo(instance) {
    print "MetaClass of ${instance} is ${instance.metaClass.class.simpleName}"
    println " with delegate ${instance.metaClass.delegate.class.simpleName}"
}

printMetaClassInfo(2)
println "MetaClass of Integer is ${Integer.metaClass.class.simpleName}"
println "Adding a method to Integer metaClass"
Integer.metaClass.someNewMethod = { -> /* */ }
printMetaClassInfo(2)
println "MetaClass of Integer is ${Integer.metaClass.class.simpleName}"

println "**" * 20

@Immutable
class MyClass {
    String name
}

obj1 = new MyClass("obj1")
printMetaClassInfo(obj1)
println "Adding a method to MyClass metaClass"
MyClass.metaClass.someNewMethod = { -> /* */ }
printMetaClassInfo(obj1) // 기존 metaClass를 계속 사용중.

println "obj2 created later"
obj2 = new MyClass("obj2")
printMetaClassInfo(obj2) // 새로운 ExpandoMetaClass 사용