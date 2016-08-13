package ch02

// ... 기반 가변인자
def receiveVarArgs(int a, int ... b) {
    println "You passed $a and $b"
}

// array 기반 가변인자
def receiveArray(int a, int[] b) {
    println "You passed $a and $b"
}

receiveVarArgs(1, 2, 3, 4, 5)
receiveArray(1, 2, 3, 4, 5)

int[] values = [2, 3, 4, 5]
receiveVarArgs(1, values)
receiveVarArgs(1, [2, 3, 4, 5] as int[])