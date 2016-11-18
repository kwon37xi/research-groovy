import groovy.transform.Canonical
import groovy.transform.ToString

// @Canonical = @ToString, @EqualsAndHashCode, @TupleConstructor 를 모두 합친것

@Canonical
class Building {
    String name
    int floors
    boolean officeSpace
}

def officeSpace = new Building('Initech office', 1, true)

assert officeSpace.toString() == 'Building(Initech office, 1, true)'

def theOffice = new Building('Werham Hogg Paper Company')
assert theOffice.floors == 0

assert theOffice.officeSpace == false

theOffice.officeSpace = true

def anotherOfficeSpace = new Building(name: 'Initech office', floors: 1, officeSpace: true)
assert anotherOfficeSpace == officeSpace

// equals, hashCode가 추가되었기 때문에 Set에 중복 이들 어 갈수없다.
def offices = [officeSpace, theOffice, anotherOfficeSpace] as Set
assert offices.size() == 2
assert offices.name.join(',') == 'Initech office,Werham Hogg Paper Company'

@Canonical
@ToString(excludes='age')
class Person {
    String name
    int age
}

def mrhaki = new Person('mrhaki', 37)
assert mrhaki.toString() == 'Person(mrhaki)'