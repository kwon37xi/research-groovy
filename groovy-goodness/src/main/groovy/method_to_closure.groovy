// method를 closure로 : .& operator 사용
def names = ['groovy', 'grails', 'mrhaki']

names.each { println 'Normal closure says: Hello ' + it + '!' }

def groovySays(s) {
    println "Groovy says: Hello ${s}"
}
names.each this.&groovySays

def javaSays = groovygoodness.JavaObject.&javaSays
names.each javaSays