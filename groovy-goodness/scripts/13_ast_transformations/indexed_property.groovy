import groovy.transform.IndexedProperty

// Collection type 프라퍼티를 indexed 프라퍼티로 만들 수 있다. javabean 규약

// propertyName 컬렉션 프라퍼티가 존재할때 아래를 자동 생성. : Groovy를 사용할 때는 별로 의미 없는 기능.

// public PropertyElement getPropertyName(int idex)
// public void setPropertyName(int index, PropertyElement element)
// public PropertyElement[] getPropertyName()
// public void setPropertyName(PropertyElement[])

class Group {
    String name
    List members = []
}

class IndexedGroup {
    String name
    @IndexedProperty List members = []
}

def group = new Group(name: 'Groovy')
group.members[0] = 'mrhaki'
group.members[1] = 'Hubert'

assert 2 == group.members.size()
assert ['mrhaki', 'Hubert'] == group.members

try {
    group.setMembers(0, 'hubert')
    assert false
} catch (MissingMethodException e) {
    assert e
}

def indexedGroup = new IndexedGroup(name: 'Grails')
indexedGroup.members[0] = 'mrhaki'
indexedGroup.setMembers 1, 'Hubert'

assert 2 == indexedGroup.members.size()
assert 'mrhaki' == indexedGroup.getMembers(0)
assert 'Hubert' == indexedGroup.members[1]