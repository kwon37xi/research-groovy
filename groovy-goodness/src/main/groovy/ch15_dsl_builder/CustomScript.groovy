package ch15_dsl_builder

abstract class CustomScript extends Script {
    def run() {
        before()
        try {
            final result = runCode()
            println "Script says $result"
        } finally {
            println "SCript ended"
        }
    }

    private void before() {
        println "Script starts"
    }

    abstract def runCode()
}
