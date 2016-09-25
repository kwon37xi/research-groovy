// getter/setter가 기본 생성됨.
// final field는 getter만 생성됨.
// car.@field 는 getter/setter 없이 필드에 접근
class Car {
    int numberOfDoors
    String model
    String brand
    boolean automatic
    double price

    public void setBrand(brand) {
        this.brand = brand + ' (set via setter method)'
    }

    String toString() {
        "[Car details => brand: '${brand}', model: '${model}', #doors : '${numberOfDoors}, automatic: '${automatic}, price: '${price}'"
    }
}

Car ford= new Car(brand: 'Ford', model: 'Focus', numberOfDoors: 4, automatic: false, price: 24995)
println ford.brand

ford.@brand = 'Overrule brand'
println ford.brand
println ford.@brand

