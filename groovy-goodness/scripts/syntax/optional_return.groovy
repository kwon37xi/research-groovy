def doIt(b) {
    if (b) {
        "You are true"
    } else {
        "You are false"
    }
}

assert "You are true" == doIt(true)
assert "You are false" == doIt(false)

def tryIt(file) {
    try {
        new File(file).text
    } catch (e) {
        "Received exception: ${e.message}"
    } finally {
        println "Finally is executed but nothing is returned"
        'Finally reached'

        // finally에서는 명시적으로 return 을 붙이면 return 이 수행되고 그렇지 않으면
        // return하지 않는다.
    }
}

assert 'Received exception: invalidfilename (그런 파일이나 디렉터리가 없습니다)' == tryIt('invalidfilename')

def newFile = new FileWriter('/tmp/test').withWriter { it.write('file contents') }
assert 'file contents' == tryIt('/tmp/test')