// metaClass로 static method를 추가할 때는 'static' 에 넣으면 된다.

class User {
    String username, email
    String toString() { "$username, $email" }
}

User.metaClass.static.new = { u, e ->
    new User(username: u, email: e)
}

def u = User.new('mrhaki', 'mail@host.com')
assert u.username == 'mrhaki'
assert u.email == 'mail@host.com'
