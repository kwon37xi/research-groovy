class GroovyTimerTask extends TimerTask {
    Closure closure
    void run() {
        closure()
    }
}

class TimerMethods {
    static TimerTask runEvery(Timer timer, long delay, long period, Closure codeToRun) {
        TimerTask task = new GroovyTimerTask(closure: codeToRun)
        timer.schedule task, delay, period
        task
    }
}

use (TimerMethods) {
    def timer = new Timer()
    def task = timer.runEvery(1000, 5000) { // 최초 시작시 1초 delay, 그 이후 5초마다 실행.
        println "Task executed at ${new Date()}."
    }
    println "Current date is ${new Date()}."
}