package ch07

process = "wc".execute()

process.out.withWriter {
    it << "Let the World know...\n"
    it << "Groovy Rocks!\n"
}

println process.in.text
// or process.text

// 배열 혹은 List에도 execute() 메소드가 있다. 각 항목에 toString() 한 결과 문자열을 실행한다.
String[] command = ['/home/kwon37xi/.sdkman/candidates/groovy/current/bin/groovy', '-e', '"print \'Groovy\'"']
println "Calling ${command.join(' ')}"
println command.execute().text
