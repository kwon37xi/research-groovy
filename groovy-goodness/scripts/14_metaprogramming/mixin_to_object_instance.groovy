// 객체 인스턴스에 mixin 적용가능하다. metaClass 사용.

class Parrot {
    static String speak(String text) {
        /"$text" Polly wants a cracker!/
    }
}

String s = 'Groovy is Gr8'
s.metaClass.mixin Parrot

assert s.speak() == '"Groovy is Gr8" Polly wants a cracker!'

String other = 'Groovy and Grails'

try {
    other.speak()
    assert false
} catch (MissingMethodException e) {
    assert e.message.startsWith('No signature of method: java.lang.String.speak() is applicable for argument types: () values: []')
}
