import groovy.beans.Bindable

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener

@Bindable
class User {
    String name, email
}

def u = new User(name: 'mrhaki', email: 'mrhaki@mrhaki.com')

abstract class ChangedProperty implements PropertyChangeListener {
    List<PropertyChangeEvent> events = []

    @Override
    void propertyChange(PropertyChangeEvent event) {
        events << event
        onPropertyChange(event)
    }

    // abstract method 한개.
    abstract void onPropertyChange(PropertyChangeEvent event)
}

ChangedProperty changedProperty = { event -> println "Changed property $event.propertyName from $event.oldValue to $event.newValue" } // onPropertyChange 메소드 구현

u.addPropertyChangeListener changedProperty

u.name = 'Hubert A. Klein Ikkink'
u.email = 'hubert@mrhaki.com'

assert changedProperty.events.size() == 2
assert changedProperty.events.first().oldValue == 'mrhaki'
assert changedProperty.events.first().newValue == 'Hubert A. Klein Ikkink'
