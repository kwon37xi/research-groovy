package ch06

langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

println langs.getClass().name // java.util.LinkedHashMap
println langs.class // 이는 getClass() 메소드를 호출하지 않고 langs['class'] 항목을 탐색한다.

println langs['Java']
println langs['C++']
println langs.Java
println langs.'C++'

langs = ['C++': 'Stroustrup', Java: 'Gosling', Lisp: 'McCarthy']
