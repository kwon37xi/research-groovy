package metaobject

/**
 * methodMissing은 inner class에서는 컴파일이 불가.
 */
class StudentForMethodMissing implements GroovyInterceptable {
    protected dynamicProps = [:]

    void setProperty(String pName, val) {
        dynamicProps[pName] = val
    }

    def getProperty(String pName) {
        dynamicProps[pName]
    }

    def methodMissing(String name, def args) {
        println "Missing method"
    }

}