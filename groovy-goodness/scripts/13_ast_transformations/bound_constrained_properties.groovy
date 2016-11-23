// bound property : 한 프라퍼티의 변경이 다른 빈에게 전달되는 것.
// constrained property : 한 프라퍼티의 변경이 다른 bean에서 유효성검사를 거치는 것. 유효하지 않으면 변경 거부.

// @Bindable, @Vetoable
// veto : 거부하다, 거부권
import groovy.beans.Bindable
import groovy.beans.Vetoable

import java.beans.PropertyChangeEvent
import java.beans.PropertyVetoException

class Car {
    int numberOfDoors
    @Vetoable String model
    @Vetoable String brand
    boolean automatic
    @Bindable double price

    String toString() {
        "[Car details => brand: '${brand}', model: '${model}', #doors: '${numberOfDoors}', automatic: '${automatic}', price: '${price}'"
    }
}

// addPropertyChangeListener(), removePropertyChangeListener(), addVetoableChangeListener(), removeVetoableChangeListener() 메소드가 추가된다.
// setPrice() 끝에서 firePropertyChange 호출됨.
// setModel(), setBrand() 끝에서는 fireVetoableChange 호출된다.

def toyota = new Car(brand: 'Toyota', model: 'Verso', price: 28919, numberOfDoors: 5)

// 도대체 propertyChange 프라퍼티는 어디서 등장하는 것인가?
toyota.propertyChange = { PropertyChangeEvent pce ->
    if (pce.propertyName == 'price') {
        println "The price has changed. Inform sales the new price is '${pce.newValue}'"
    }
}

// 계속 add 되고 있음.
toyota.propertyChange = {
    println "== second property change"
}

toyota.vetoableChange = { PropertyChangeEvent pce ->
    if (pce.propertyName == "brand") {
        if (!(pce.newValue in ['Toyota', 'Lexus'])) {
            throw new PropertyVetoException('New value is not Toyota or Lexus', pce)
        }
    }

    if (pce.propertyName == 'model') {
        if (pce.newValue ==~ /.*\d+.*/) {
            throw new PropertyVetoException('No numbers in model names allowed.', pce)
        }
    }
}

toyota.price = 30995
assert 30995 == toyota.price

toyota.brand = 'Lexus'
assert 'Lexus' == toyota.brand

try {
    toyota.brand = 'AUDI'
    assert false, 'We should not be able to set this value.'
} catch (PropertyVetoException e) {
    assert true
}


try {
    toyota.model = 'A5'
    assert false: 'We should not be able to set this value.'
} catch (PropertyVetoException e) {
    assert true
}
