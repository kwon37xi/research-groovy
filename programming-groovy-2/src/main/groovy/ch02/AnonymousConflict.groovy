package ch02

class Calibrator {
    Calibrator(calculationBlock) {
        print "using..."
        calculationBlock() // closure
    }
}

//def calibrator = new Calibrator() { // groovy 는 생성자에 closure를 넘기는 것이 아니라, anonymous inner class 생성으로 간주한다.
//    println("the calculation provided")
//}

// 해결책. 생성자의 파라미터로 closure를 넘긴다.
def calibrator1 = new Calibrator({
    println "the calculation provided"
})

def calculation = {
    println "another calculation provided"
}

def calibrator2 = new Calibrator(calculation)