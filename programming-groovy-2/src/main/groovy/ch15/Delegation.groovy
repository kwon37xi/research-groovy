class Worker {
    def simpleWork1(spec) {
        println "worker does work1 with spec $spec"
    }

    def simpleWork2() {
        println "worker does work2"
    }
}

class Expert {
    def advancedWork1(spec) {
        println "Expert does work1 with spec $spec"
    }

    def advancedWork2(scope, spec) {
        println "Expert does work2 with scope $scope spec $spec"
    }
}
/*
class Manager {
    def worker = new Worker()
    def expert = new Expert()

    def schedule() {
        println "Scheduling...."
    }

    def methodMissing(String name, args) {
        println "intercepting call to $name ..."

        def delegateTo = null

        if (name.startsWith('simple')) {
            delegateTo = worker
        }

        if (name.startsWith('advanced')) {
            delegateTo = expert
        }

        if (delegateTo?.metaClass.respondsTo(delegateTo, name, args)) {
            Manager instance = this
            instance.metaClass."${name}" = { Object[] varArgs ->
                delegateTo.invokeMethod(name, varArgs)
            }
            delegateTo.invokeMethod(name, args)
        } else {
            throw new MissingMethodException(name, Manager.class, args)
        }
    }
}
*/

Object.metaClass.delegateCallsTo = { Class... klassOfDelegate ->
    def objectOfDelegates = klassOfDelegate.collect {
        it.newInstance()
    }

    delegate.metaClass.methodMissing = { String name, args ->
        println "intercepting call to $name..."

        def delegateTo = objectOfDelegates.find {
            it.metaClass.respondsTo(it, name, args)
        }
        if (delegateTo) {
            delegate.metaClass."${name}" = { Object[] varArgs ->
                delegateTo.invokeMethod(name, varArgs)
            }
            delegateTo.invokeMethod(name, args)
        } else {
            throw new MissingMethodException(name, delegate.getClass(), args)
        }
    }
}
class Manager {
    {
        delegateCallsTo Worker, Expert, GregorianCalendar
    }

    def schedule() {
        println "Scheduling"
    }
}

peter = new Manager()
peter.schedule()
peter.simpleWork1('fast')
peter.simpleWork1('quality')
peter.simpleWork2()
peter.simpleWork2()
peter.advancedWork1('fast')
peter.advancedWork1('quality')
peter.advancedWork2('prototype', 'fast')
peter.advancedWork2('product', 'quality')

println "Is 2008 a leap year? " + peter.isLeapYear(2008) // from GregorianCalendar

try {
    peter.simpleWork3()
} catch (ex) {
    println ex
}
