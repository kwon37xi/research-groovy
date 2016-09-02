carA = new Expando()
carB = new Expando(year: 2012, miles: 0)

carA.year = 2012
carA.miles = 10

println "carA: " + carA
println "carB: " + carB

car = new Expando(year: 2012, miles: 0, turn: {
    println 'turning...'
})

car.drive = {
    miles += 10
    println "$miles miles driven"
}

car.drive()
car.turn()
