import ch16.EAM

@EAM
class Resource {
    private def open() {
        print "opened..."
    }

    private def close() {
        print "closed..."
    }

    private read() { print "read..." }
    private write() { print "write..." }
}

println "Using Resource"

// @EAM 에 의해 use 메소드 자동으로 생성되었음.
Resource.use {
    read()
    write()
}