// getAt(String)

class User {
    String name
}

def list = [new Date(), new User(name: 'mrhaki'), 42.0, 'Groovy roocks!']

assert list['class']['name'] == ['java.util.Date', 'User', 'java.math.BigDecimal', 'java.lang.String']

println list['class'] // List의 각 element의 getClass() 결과를 가진 새로운 리스트
println list['class']['name'] // getClass().getName() 의 리스트
