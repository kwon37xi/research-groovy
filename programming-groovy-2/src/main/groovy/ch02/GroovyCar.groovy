package ch02


class Car {
    def miles = 0 // getter/setter 자동 생성
    final year // final 은 getter만 자동 생성

    Car(theYear) { year = theYear }

}

Car car = new Car(2008)

println "Year: $car.year"
println "Miles: $car.miles"
println 'Setting miles'

car.miles = 25
println "Miles: $car.miles"
