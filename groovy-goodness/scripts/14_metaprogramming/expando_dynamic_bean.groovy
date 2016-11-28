// Expando : dynamic bean.
// 프라퍼티와 메소드를 추가할 수 있다.

def user = new Expando(username: 'mrhaki')
assert user.username == 'mrhaki'

user.email = 'email@host.com'
assert 'email@host.com' == user.email

user.printInfo = { writer ->
    writer << "Username: $username"
    writer << ", email: $email"
}

def sw = new StringWriter()
user.printInfo(sw)

assert sw.toString() == 'Username: mrhaki, email: email@host.com'