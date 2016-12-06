// groovy script는 기본적으로 groovy.lang.Script 클래스 구현체.
// Script를 상속하여 별도로 만들 수 있음.

import org.codehaus.groovy.control.CompilerConfiguration

class Car {
    String state
    Long distance = 0
}

abstract class CarScript extends Script {
    def start() {
        this.binding.car.state = 'started'
    }

    def stop() {
        this.binding.car.state = 'stopped'
    }

    def drive(distance) {
        this.binding.car.distance += distance
    }
}

def compilerConfiguration = new CompilerConfiguration()
compilerConfiguration.scriptBaseClass = CarScript.class.name // custom script class 지정

def car = new Car()
def binding = new Binding(car: car)

def shell = new GroovyShell(this.class.classLoader, binding, compilerConfiguration)

def carDsl = '''
start()
drive 20
stop()
'''

shell.evaluate carDsl

assert car.distance == 20
assert car.state == 'stopped'