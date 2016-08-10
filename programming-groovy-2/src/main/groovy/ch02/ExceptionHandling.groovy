package ch02

def openFile(fileName) {
    new FileInputStream(fileName)
}

try {
    openFile("nonexistentfile")
} catch (ex) { // Exception type 을 생략하면 모든 예외를 잡는다. 단, Error, Throwable은 잡지 않는다.
    println "oops: " + ex
}

