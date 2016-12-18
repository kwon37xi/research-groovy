// properties 파일이 아니라 groovy script 자체를 설정파일로 사용할 수 있게 해줌.
// ConfigSlurper 로 ConfigObject로 파싱. 이는 LinkedHashMap을 상속했음.

// profile 별로 설정하는 기법도 있음.

def mail = '''
mail.hostname = 'localhost'
mail {
    ['user', 'password'].each {
        this."${it}" = 'secret'
    }
}

environments {
    dev {
        mail.hostname = 'local'
    }
    test {
        mail.hostname = 'test'
    }
    prod {
        mail.hostname = 'prod'
    }
}
'''

def app = '''
app {
    version = version() // use method in script
}

def version() {
    "1.0-${releasedate.format('yyyy_MM_dd')}"
}
'''

def mailConfig = new ConfigSlurper('prod').parse(mail)

def appSlurper = new ConfigSlurper()
appSlurper.setBinding([releasedate: new Date(109, 9, 10)])
def appConfig = appSlurper.parse(app)

def config = mailConfig.merge(appConfig)

assert config.mail.hostname == 'prod'
assert config.mail.user == 'secret'
assert config.mail.password == 'secret'
assert config.app.version == '1.0-2009_10_10'