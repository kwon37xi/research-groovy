class User {
    String username

    String 'switch'() {
        username = username.reverse()
    }
}



def u = new User(username: 'mrhaki')
assert 'ikahrm' == u.switch() // 뒤집기
assert 'mrhaki' == u."switch"() // 다시 한 번 뒤집기