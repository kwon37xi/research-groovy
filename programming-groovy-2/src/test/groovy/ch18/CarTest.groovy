package ch18

class CarTest extends GroovyTestCase {
    Car car

    void setUp() {
        car = new Car()
    }

    void tearDown() {
        // no op
    }

    void testInitialize() {
        assertEquals 0, car.miles
    }

    void testDrive() {
        car.drive(10)
        assertEquals 10, car.miles
    }

    void testDriveNegativeInput() {
        car.drive(-10)
        assertEquals 0, car.miles
    }
}
