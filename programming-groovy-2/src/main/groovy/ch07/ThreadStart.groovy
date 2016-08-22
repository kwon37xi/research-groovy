package ch07

def printThreadInfo(msg) {
    def currentThread = Thread.currentThread()

    println "$msg Thread is ${currentThread}. Daemon? ${currentThread.isDaemon()}"
}

printThreadInfo('Main')

Thread.start {
    printThreadInfo 'Started'
    sleep(3000) {
        println "Interrupted"
    }
    println "Finished Started"
}

sleep(1000)

Thread.startDaemon {
    printThreadInfo 'Started Daemon'
    sleep(5000) {
        println "Interrupted"
    }
    println "Finished started Daemon" // startDaemon일 때는 이거 출력안됨. start 로 변경하면 출력됨.
}
