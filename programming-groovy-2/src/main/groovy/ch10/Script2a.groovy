println "In Script2"

name = "KwonNam"

// 모든 스크립트는 Binding binding 객체를 가지고 있다.;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
shell = new GroovyShell(binding); // 현재 스크립트(Script2a)의 기본 Binding 객체
result = shell.evaluate(new File('Script1a.groovy'))

println "Script1a returned : $result"
println "Hello $name"