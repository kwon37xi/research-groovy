// environments block
// Groovy 2.3부터 사용자정의 조건적 설정 블럭을 만들 수 있음.
// registerConditionalBlock('사용자정의환경블럭이름', env)
def config = '''
servers {
    local {
        mail.host = 'greenmail'
    }
    prod {
        mail.host = 'mail.server'
    }
}

environments {
    local {
        appName = 'local'
    }
    prod {
        appName = 'production'
    }
}
'''


def createConfig = { env ->
    def configSlurper = new ConfigSlurper(env)
    configSlurper.registerConditionalBlock('servers', env)
    configSlurper
}

def configuration = createConfig('prod').parse(config)

assert configuration.mail.host == 'mail.server'
assert configuration.appName == 'production'

configuration = createConfig('local').parse(config)

assert configuration.mail.host == 'greenmail'
assert configuration.appName == 'local'