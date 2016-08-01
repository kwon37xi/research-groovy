package strings


class StringExample {
    static void main(String[] args) {
        String sample = "Hello World"
        println(sample[4])
        println(sample[-1]) // 뒤에서 첫번째
        println(sample[1..2]) // index 1~2
        println(sample[4..2]) // index 4 ~ 2 : 역순

        // String repetition

        String a = "Hello"
        println(a * 3)
        println("Hello" * 3)

    }
}
