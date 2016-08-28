class PureCar {
    def check() {
        System.out.println "check called..."
    }

    def start() {
        System.out.println "start called..."
    }

    def drive() {
        System.out.println "drive called..."
    }
}

PureCar.metaClass.invokeMethod = { String name, args ->
    System.out.print("Call to $name intercepted... ")

    if (name != 'check') {
        System.out.print('running filter... ')
        PureCar.metaClass.getMetaMethod('check').invoke(delegate, null)
    }

    def validMethod = PureCar.metaClass.getMetaMethod(name, args)
    if (validMethod != null) {
        validMethod.invoke(delegate, args)
    } else {
        PureCar.metaClass.invokeMissingMethod(delegate, name, args)
    }
}

car = new PureCar()

car.start()
car.drive()
car.check()

try {
    car.speed()
} catch (Exception ex) {
    println ex
}