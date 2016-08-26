println "In Script3"

// 새로운 바인딩을 만들어 현재 스크립트와 호출될 스크립트의 경게 분리
binding1 = new Binding()

binding1.setProperty('name', 'KwonNam')
GroovyShell shell = new GroovyShell(binding1)
shell.evaluate(new File('Script1a.groovy'))

binding2 = new Binding()
binding2.setProperty('name', 'Dan')
shell.binding = binding2
shell.evaluate(new File('Script1a.groovy'))

// 스크립트에 명령행 인자를 넘기고 싶다면 GroovyShell.run 을 사용한다.
