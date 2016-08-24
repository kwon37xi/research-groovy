package ch07

def list = [1,2,3]
list[1] = 100
println list

try {
    def immutableList = list.asImmutable()
    immutableList[1] = 10
} catch (ex) {
    println ex.getClass().name
}

def synchronizedList = list.asSynchronized()
println synchronizedList.getClass().name

println new Date()
Timer timer = new Timer("groovy timer")
timer.runAfter(3000) {
    println "runAfter 3000ms ${new Date()}"
}