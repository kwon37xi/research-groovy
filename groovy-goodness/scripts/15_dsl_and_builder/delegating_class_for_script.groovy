// Groovy 2.2 DelegatingScript class.
// DelegatingScript를 baseClass로 지정하고,


import org.codehaus.groovy.control.CompilerConfiguration

class Car {
    String state
    Long distance = 0
}

class CarScript {
    private final car

    CarScript(final car) {
        this.car = car
    }

    def start() {
        car.state = 'started'
    }

    def stop() {
        car.state = 'stopped'
    }

    def drive(distance) {
        car.distance += distance
    }
}

def compilerConfiguration = new CompilerConfiguration()
compilerConfiguration.scriptBaseClass = DelegatingScript.class.name

def shell = new GroovyShell(this.class.classLoader, new Binding(), compilerConfiguration)

def carDsl = '''
start()
drive 200
stop()
'''

def car = new Car()

def carScript = new CarScript(car)

// 파싱만 한다.
def script = shell.parse(carDsl)
script.setDelegate(carScript)


script.run()

assert car.distance == 200
assert car.state == 'stopped'