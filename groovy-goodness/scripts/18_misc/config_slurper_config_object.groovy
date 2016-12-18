// ConfigSlurper 는 ConfigObject 리턴한다.
// ConfigObject.isSet

def config = '''
app {
    version = 0
    active = false
}
'''

def configuration = new ConfigSlurper().parse(config)

configuration.app.with {
    assert !active
    assert isSet('active')

    assert !enabled
    assert !isSet('enabled')

    assert !version
    assert isSet('version')
    assert version == 0
}

