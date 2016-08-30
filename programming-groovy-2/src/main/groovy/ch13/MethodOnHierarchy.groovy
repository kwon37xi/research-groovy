daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, (int) delegate) // delegate -> Integer object
    today.time // java.util.Date
}
Integer.metaClass.daysFromNow = daysFromNow
Long.metaClass.daysFromNow = daysFromNow

println 5.daysFromNow()
println 5L.daysFromNow()

Number.metaClass.someMethod = { ->
    println "someMethod called with ${delegate}"
}

2.someMethod()
2L.someMethod()