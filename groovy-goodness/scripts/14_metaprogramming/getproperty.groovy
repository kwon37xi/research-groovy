// getProperty() 객체의 프라퍼티에 접근할 때 호출됨.
// 이를 오버라이드하여 존재하지 않는 프라퍼티에 대한 행위 추가 가능.

class User {
    String username
}

User.metaClass.getProperty = { String propName ->
    def meta = User.metaClass.getMetaProperty(propName)
    if (meta) {
        meta.getProperty(delegate)
    } else {
        'Dynamic property for User'
    }
}

def mrhaki = new User(username: 'mrhaki')
def hubert = new User(username: 'hubert')

assert mrhaki.username == 'mrhaki'
assert mrhaki.fullname == 'Dynamic property for User'