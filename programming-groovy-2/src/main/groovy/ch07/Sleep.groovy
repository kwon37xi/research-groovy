package ch07

thread = Thread.start {
    println "Thread started"
    startTime = System.nanoTime()
    new Object().sleep(2000)
    endTime = System.nanoTime()
    println "Thread done in ${(endTime - startTime)/10**9} seconds"
}

sleep(2000) // static method 라서 굳이 new Object().sleep() 안해도 됨.
println "Let's interrupt that thread"
thread.interrupt() // 아무일도 안 생김. thread interrupt ignored
thread.join()

def playWithSleep(flag) {
    thread = Thread.start {
        println "Thread started"
        startTime = System.nanoTime()
        sleep(2000) {
            println "Interrupted... " + it // it 는 Exception 객체
            flag // true 이면 interrupt 작동하고 false이면 무시
        }
        endTime = System.nanoTime()
        println "Thread done in ${(endTime - startTime)/10**9} seconds"
    }

    thread.interrupt()
    thread.join()
}

playWithSleep(true)
playWithSleep(false)
