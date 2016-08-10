package ch02

for (i in 0..2) { print 'ho '}
println 'Merry Groovy!'
// println, print 는 java.lang.Object 메소드로 추가 되어 바로 사용가능하다.

// Integer.upto 메소드 추가
0.upto(2) { print "$it "}
