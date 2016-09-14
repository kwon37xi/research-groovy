import org.codehaus.groovy.runtime.typehandling.GroovyCastException

def myvar = 42
assert myvar instanceof Integer

myvar = 'I am a String'
assert myvar instanceof String

String s = 'I am String'
assert s instanceof String

s = new Integer(100) // 문자열로 바뀌어서 저장됨. 아마도 toString() 호출??
assert s instanceof String

int i = 42
assert i instanceof Integer

try {
    i = 'test'
} catch(e) {
    assert e instanceof GroovyCastException
}