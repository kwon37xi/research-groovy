package ch02

for (ch = 'a'; ch < 'd'; ch++) {
    println ch
}
// ++ -> next()

for (ch in 'a'..'c') {
    println ch
}

lst = ['hello']
lst << 'there'

println lst

class ComplexNumber {
    def real, imaginary

    // overload + operator
    def plus(other) {
        new ComplexNumber(real: real + other.real, imaginary: imaginary + other.imaginary)
    }

    String toString() {
        "$real ${imaginary > 0 ? '+' : ''} ${imaginary}i"
    }
}

c1 = new ComplexNumber(real: 1, imaginary: 2)
c2 = new ComplexNumber(real: 4, imaginary: 1)

println c1 + c2