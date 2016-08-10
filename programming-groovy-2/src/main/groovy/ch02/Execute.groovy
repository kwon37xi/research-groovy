package ch02

// java.lang.String 에 Process execute() 메소드 추가됨
println "svn help".execute().text

println "svn help".execute().getClass().name // java.lang.UNIXProcess

println "ls -l".execute().text


