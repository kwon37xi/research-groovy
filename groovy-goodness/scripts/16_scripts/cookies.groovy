// jar cvf sample.jar cookies.groovy
// groovy jar:file:sample.jar'!'/cookies.groovy

// jar를 웹서버에 올리고서는
// jar:http://<address>/sample.jar!/cookies.groovy
println "Running from inside a JAR"
def cookies = ['Cookie', 'Biscuit'].collect { it.toUpperCase() }.join(',')
println cookies
