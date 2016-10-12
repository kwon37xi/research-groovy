// find, findAll
// Object 에 있는 메소드임.

class User {
    boolean enabled
    Boolean asBoolean() { // asBoolean 이 구현돼 있으면 groovy truth 검사가 가능해짐.
        enabled
    }
}

def items = [0, false, null, [], [:], '', new User(enabled: false), 'Groovy rocks!', 101]

assert items.find() == 'Groovy rocks!'

assert items.findAll() == ['Groovy rocks!', 101]