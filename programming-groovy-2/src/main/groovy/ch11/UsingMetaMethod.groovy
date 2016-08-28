str = "hello"
methodName = 'toUpperCase' // Name may come from an input instread of beging hard coded

methodOfInterest = str.metaClass.getMetaMethod(methodName)
println methodOfInterest.invoke(str) // HELLO

print "Does String respond to toUpperCase()? "

// 원래는 메소드 리스트를 리턴하지만, list가 empty 이면 false, 아니면 true로 자동 변환된다.
println String.metaClass.respondsTo(str, 'toUpperCase') ? 'yes': 'no'

print 'Does String respond to compareTo(String)? '
println String.metaClass.respondsTo(str, 'compareTo', 'test') ? 'yes' : 'no'

print 'Does String respond to toUpperCase(int)? '
println String.metaClass.respondsTo(str, 'toUpperCase', 5) ? 'yes' : 'no'

