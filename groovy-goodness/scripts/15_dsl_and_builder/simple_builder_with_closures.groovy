import groovy.transform.Canonical

// methodMissing과 propertyMissing으로 builder 만들기


@Canonical
class Reservation {
    Flight flight = new Flight()
    List<Person> passengers = []
    Boolean retourFlight = false
}

@Canonical
class Person {
    String name
}

@Canonical
class Airport {
    String name, city
}

@Canonical
class Flight {
    Airport from, to
}

class ReservationBuilder {
    Reservation reservation

    private Boolean passengersMode = false

    Reservation make(Closure definition) {
        reservation = new Reservation()
        runClosure definition
        reservation
    }

    void passengers(Closure names) {
        passengersMode = true

        runClosure names

        passengersMode = false
    }

    void name(String personName) {
        if (passengersMode) {
            reservation.passengers << new Person(name: personName)
        } else {
            throw new IllegalStateException("name() only allowed in passengers context.")
        }

    }

    def methodMissing(String name, arguments) {
        if (name in ['to', 'from']) {
            def airport = arguments[0].split(',')
            def airPortname = airport[0].trim()
            def city = airport[1].trim()
            reservation.flight."$name" = new Airport(name: airPortname, city: city)
        }
    }

    def propertyMissing(String name) {
        if (name == 'retourFlight') {
            reservation.retourFlight = true
        }
    }

    private runClosure(Closure runClosure) {
        Closure runClone = runClosure.clone()

        runClone.delegate = this

        runClone.resolveStrategy = Closure.DELEGATE_ONLY

        runClone()
    }
}

def reservation = new ReservationBuilder().make {
    passengers {
        name 'mrhaki'
        name 'Hubert A. Klein Ikkink'
    }

    from 'Schiphol, Amsterdam'
    to 'Kastrup, Copenhagen'
    retourFlight
}

assert reservation.flight.from == new Airport(name: 'Schiphol', city: 'Amsterdam')
assert reservation.flight.to == new Airport(name: 'Kastrup', city: 'Copenhagen')
assert reservation.passengers.size() == 2
assert reservation.passengers == [
        new Person(name: 'mrhaki'),
        new Person(name: 'Hubert A. Klein Ikkink')
]
assert reservation.retourFlight