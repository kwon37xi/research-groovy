addShutdownHook {
    println ''
    println 'Script is ended.'
}


println 'Script is started.'
println 'Press Ctrl-C to stop this script or weait 10 seconds'
(1..10).each {
    println "..$it"
    Thread.sleep 1000
}

// 마지막에 Script is ended 출력됨.