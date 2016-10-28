// Groovy 2.2 부터 closure가 as 키워드 없이 암시적으로 interface 타입으로 변환된다.
// 단일 abstract 메소드 interface, 단일 abstract 메소드 abstract class 에 대해 작동.

// @Bindable 클래스의 모든 필드 변화를 PropertyChangeListener 에게 전달.
import groovy.beans.Bindable

@Bindable
class User {
    String name, email
}

def u = new User(name: 'mrhaki', email: 'mrhaki@mrhaki.com')

u.addPropertyChangeListener { event -> println "Changed property $event.propertyName from $event.oldValue to $event.newValue"}

u.name = 'Hubera A. Klein Ikkink'
u.email = 'hubert@mrhaki.com'
