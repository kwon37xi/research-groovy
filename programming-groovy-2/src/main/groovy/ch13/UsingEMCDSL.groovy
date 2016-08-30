Integer.metaClass {
    daysFromNow = { ->
        Calendar today = Calendar.instance
        today.add(Calendar.DAY_OF_MONTH, delegate)
        today.time
    }

    getDaysFromNow = { ->
        Calendar today = Calendar.instance
        today.add(Calendar.DAY_OF_MONTH, delegate)
        today.time
    }

    'static' {
        isEven = { val -> val % 2 == 0 }
    }

    constructor = { Calendar calendar ->
        new Integer(calendar.get(Calendar.DAY_OF_YEAR))
    }

    constructor = { int val ->
        println "Intercepting constructor call"
        constructor = Integer.class.getConstructor(Integer.TYPE)
        constructor.newInstance(val)
    }
}

println 5.daysFromNow()
println 5.daysFromNow // without parentheses

println "Is 2 even? " + Integer.isEven(2)
println "Is 3 even? " + Integer.isEven(3)
println new Integer(4)
println new Integer(Calendar.instance)
