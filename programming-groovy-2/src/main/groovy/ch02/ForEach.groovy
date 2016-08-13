package ch02

String[] greetings = ["Hello", "Hi", "Howdy"]

for (String greet : greetings) { // Java for-each에서는 type 혹은 def 필수
    println greet
}

for (greet in greetings) { // Groovy for-each 에서는 type 불필요.
    println greet
}