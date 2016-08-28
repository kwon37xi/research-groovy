class Car implements GroovyInterceptable {
    def check() {
        System.out.println "check called..."
    }

    def start() {
        System.out.println "start called..."
    }

    def drive() {
        System.out.println "drive called..."
    }

    def invokeMethod(String name, args) {
        System.out.print("Call to $name intercepted... ")

        // 일단 모든 메소도 호출시마다 check()를 호출하고
        if (name != 'check') {
            System.out.print("running filter... ")
            Car.metaClass.getMetaMethod("check").invoke(this, null)
        }

        // 이제 실제 메소드를 호출한다.
        MetaMethod validMethod = Car.metaClass.getMetaMethod(name, args)
        if (validMethod != null) {
            validMethod.invoke(this, args)
        } else {
            // metaClass의 invokeMethod가 메소드 호출을 변경없는 기본동작으로 수행할듯.
            // 이 경우 메소드가 존재하지 않으므로 MissingMethodException 발생
            Car.metaClass.invokeMethod(this, name, args)
        }
    }
}

car = new Car()
car.start()
car.drive()
car.check()

try {
    car.speed()
} catch (Exception ex) {
    println ex
}