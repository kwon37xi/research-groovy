package ch05

import java.util.regex.Pattern

obj = ~"hello"
println obj.getClass().name // java.util.regex.Pattern

// "/" 로 RegEx를 만들면 "\" 를 escape 하지 않아도 된다.

Pattern patternWithSlash = ~/\d*\w*/
Pattern patternWithQuotes = ~"\\d*\\w*"
println patternWithSlash.pattern() == patternWithQuotes.pattern()

pattern = ~"(G|g)roovy"
text = 'Groovy is Hip'

if (text =~ pattern) { // partial match
    println 'match'
} else {
    println 'no match'
}

if (text ==~ pattern) { // exact match
    println 'match'
} else {
    println 'no match'
}

matcher = 'Groovy is groovy' =~ ~/(G|g)roovy/
println "matcher type : ${matcher.getClass().name}"

print "Size of matcher is ${matcher.size()}"
println " with elements ${matcher[0]} and ${matcher[1]}."  // Matcher type 이지만 Sequence 처럼 접근 가능함.

str = 'Groovy is groovy, really groovy'
println str
result = (str =~ /groovy/).replaceAll('hip')
println result
