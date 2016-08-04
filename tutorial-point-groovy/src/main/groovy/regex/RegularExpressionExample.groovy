package regex

class RegularExpressionExample {
    public static void main(String[] args) {
        def regex = ~'Groovy'
        println regex.class // java.util.regex.Pattern
        def matcher = "Groovy" =~ 'Groovy' // =~ 연산자는 정규표현식을 문자열로 받는다.

        println(matcher.class) // java.util.regex.Matcher

        if ('Groovy' =~ 'Groovy') { // 자동으로 boolean으로 변경된다.
            println ('Groovy matches Groovy')
        }
    }
}
