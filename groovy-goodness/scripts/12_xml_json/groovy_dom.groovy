// Java DOM handling을 쉽게하려면 DOMCategory를 사용한다.
import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

def xml = '''
<users>
    <user active="true">
        <fullname>mrhaki</fullname>
    </user>
    <user active="false">
        <fullname>Hubert A. Klein Ikkink</fullname>
    </user>
</users>
'''

def xmlDom = DOMBuilder.newInstance().parseText(xml)

def root = xmlDom.documentElement // org.w3c.dom.Element

def userInfo(user) {
    def active = user.'@active'.toBoolean()
    def fullname = user.fullname.text()
    "User with fullname $fullname is ${active ? 'active' : 'not active'}"
}
use (DOMCategory) {
    def users = root.user
    println users.getClass().getName() // groovy.xml.dom.DOMCategory$NodesHolder
    assert 2 == users.size()

    assert 'User with fullname mrhaki is active' == userInfo(users[0])
    assert 'User with fullname Hubert A. Klein Ikkink is not active' == userInfo(users[1])

    assert 'mrhaki' == users.findAll {
        it.'@active'.toBoolean()
    }[0].fullname.text()
}

