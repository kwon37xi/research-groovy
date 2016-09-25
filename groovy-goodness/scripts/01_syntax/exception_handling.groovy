try {
    def url = new URL('malformedUrl')
    assert false, 'We should never get here because of the exception'
} catch (MalformedURLException e) {
    assert true
    assert e in MalformedURLException
}

def createUrl() {
    new URL('malformedUrl')
}

try {
    def url1 = createUrl()
    assert false, 'We should never get here because of the exception'
} catch (all) {
    assert true
    assert all in MalformedURLException
}
