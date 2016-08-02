package strings


class StringExample {
    static void main(String[] args) {
        String sample = "Hello World"
        println(sample[4])
        println(sample[-1]) // 뒤에서 첫번째
        println(sample[1..2]) // index 1~2
        println(sample[4..2]) // index 4 ~ 2 : 역순

        // String repetition

        String a = "Hello World"
        println(a * 3)
        println("Hello" * 3)

        println("[" + a.center(30) + "]")

        a.eachMatch(".") {
            ch -> println ch
        }

        println(a.matches("Hello"))
        println(a.matches("Hello(.*)"))

        println(a.minus("World"))
        println(a.minus("Hello"))

        println(a.next())

        println("======= padding ======")
        println(a.padLeft(14))
        println(a.padLeft(16))
        println(a.padLeft(16, '*'))
        println(a.padLeft(14, '*'))


        println(a.padRight(14));
        println(a.padRight(16));
        println(a.padRight(16,'*'));
        println(a.padRight(14,'*'));

        println(a.plus("세상아"))
        println(a.plus("세상아 또 다시한 번"))

        println(a.previous()) // --a 연산시 호출됨.
        println(--a) // a 자체의 레퍼런스가 변경됨.
        println(++a)
        println(a.reverse())
    }
}
