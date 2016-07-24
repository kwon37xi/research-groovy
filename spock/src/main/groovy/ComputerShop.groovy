/**
 *
 */
class ComputerShop {
    PersonalComputer buyPc() {
        def pc = new PersonalComputer()
        pc.vendor = "Sunny"
        pc.clockRate = 3000
        pc.ram = 8192
        pc.os = "Linux"
        return pc
    }
}
