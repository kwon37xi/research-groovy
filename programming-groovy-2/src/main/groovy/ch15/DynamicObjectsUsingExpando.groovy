data = new File('car.dat').readLines()

props = data[0].split(", ")
data -= data[0] // 첫번째 줄 삭제

def averageMilesDrivenPerYear = {
    miles.toLong() / (2008 - year.toLong())
}

cars = data.collect {
    car = new Expando()
    it.split(", ").eachWithIndex { value, index ->
        car[props[index]] = value
    }
    car.ampy = averageMilesDrivenPerYear

    car
}

props.each { name ->
    print "$name "
}
println " Aug. MPY"

ampyMethod = 'ampy'

cars.each { car ->
    for (String property : props) {
        print "${car[property]} "
    }
    println car."$ampyMethod"() // calling dynamic method
}

car = cars[0]
println "$car.miles $car.year $car.make ${car.ampy()}"
