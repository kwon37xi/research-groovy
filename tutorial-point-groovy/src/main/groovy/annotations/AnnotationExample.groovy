package annotations

/**
 * <a href="http://blog.andresteingress.com/2013/01/25/groovy-2-1-the-annotationcollector-annotation/">annotationcollection annotation</a>
 */
class AnnotationExample {

    @ValueObject(excludes = "age")
    static class UpperLimit {
        String name
        int age
    }

    static void main(String[] args) {
        def upperLimit = new UpperLimit("Hello", 13)
        println upperLimit
    }

    @OnlyIf({ it <= 6})
    void version6() {
        println "Number greater than 6"
    }
}
