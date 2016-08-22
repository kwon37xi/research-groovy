package ch07

class Car {
    int miles, fuelLevel
}

car = new Car(fuelLevel: 80, miles: 25)

properties = ['miles', 'fuelLevel']

properties.each { name ->
    println "$name = ${car[name]}"
}

car[properties[1]] = 100 // fuelLevel

println "fuelLevel now is ${car.fuelLevel}"
