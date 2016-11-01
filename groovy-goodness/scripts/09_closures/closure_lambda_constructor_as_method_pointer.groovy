// Java 8 Lambda Class::new constructor reference 처리
// 그루비에는 이런 문법 없음. 하지만 .& 으로 처리 가능.
// User.metaClass.invokeConstructor 를 생성자 레퍼런스로 넘긴다.

@groovy.transform.Immutable
class User {
    String name
    int age
}

def userList = [
        [name: 'mrhaki', age: 41],
        ['john', 30] as Object[]
]

def createUser = User.metaClass.&invokeConstructor // 생성자 레퍼런스 클로저

def users = userList.collect(createUser)

assert users.name == ['mrhaki', 'john']
assert users.age == [41, 30]