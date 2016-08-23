package ch07

new File('/tmp/output.txt').withWriter { writer ->
    writer << 'some data...'

}