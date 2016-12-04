// run external groovy script
// 외부 스크립트 실행시 변수 전달 가능

def binding = new Binding()
binding.console = { String message ->
    println message
}

binding.file = { String fileName, Closure outputCode ->
    def outputFile = new File(fileName)
    outputFile.withWriter { writer ->
        outputCode.call writer
    }
}

def shell = new GroovyShell(binding)
def script = new File('output.groovy')

shell.evaluate(script)