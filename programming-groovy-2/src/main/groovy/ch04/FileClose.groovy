package ch04

new FileWriter('/tmp/output.txt').withWriter { writer ->
    writer.write('!')
}