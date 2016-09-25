def timer = new Timer()
def task = timer.runAfter(10000) {
    println "Actually executed at ${new Date()}"
}

println "Current date is ${new Date()}. Task is executed at ${new Date(task.scheduledExecutionTime())}"