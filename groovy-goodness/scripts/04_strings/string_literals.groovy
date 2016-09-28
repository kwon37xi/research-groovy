println(/Well almost everything goes in a "slashy" 'string' without \ escaping. Good for  readable regular expression!/)

// GString은 String이 아니다.

// GString에서 closure를 사용하면 lazy evaluation이 가능해진다.
def user = new Expando(name: 'mrhaki', email: 'mail@email.com')

def directEval = "Current name value is ${user.name} and email is ${user.email}."
def lazyEval = "Current name value is ${-> user.name} and email is ${ Writer out -> out << user.email}."

user.name = 'changed username'
user.email = 'changed email'
println directEval // 변경사항 적용안됨.
println lazyEval // 변경사항 적용됨