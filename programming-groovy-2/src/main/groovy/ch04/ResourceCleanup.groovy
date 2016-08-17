package ch04

class Resource {
    def open() { print 'opened...'}
    def close() { print 'closed...'}
    def read() { print 'read...'}
    def write() { print 'write...'}

    def static use(closure) {
        def r = new Resource()
        try {
            r.open()
            closure(r)
        } finally {
            r.close()
        }
    }
}

Resource.use { res ->
    res.read()
    res.write()
}
