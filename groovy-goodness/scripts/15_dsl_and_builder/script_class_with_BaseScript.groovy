// @BaseScript
// script 에서만 사용가능.
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


def car = new Car()
def binding = new Binding(car: car)

def shell = new GroovyShell(this.class.classLoader, binding)

def carDsl = '''
start()
drive 20
stop()
'''

shell.evaluate """
// 한 줄로 ScriptClass 변수명을 기술해야만 작동함
@groovy.transform.BaseScript CarScript carScript

$carDsl
"""

assert car.distance == 20
assert car.state == 'stopped'