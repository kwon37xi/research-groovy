import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

// builderStrategy=SimpleStrategy 를 지정하면 생성된 클래스는 별도의 빌더클래스와 메소드를 갖지 않고, default prefix=set으로 지정한다.

@Builder(builderStrategy = SimpleStrategy, prefix = 'assign')
class Message {
    String from, to, subject, body
}

def message = new Message().assignFrom('mrhaki@mrhaki.com')
        .assignTo('mail@host.nl')
        .assignSubject('Sample mail')
        .assignBody('Groovy rocks!')

assert message.body == 'Groovy rocks!'
assert message.from == 'mrhaki@mrhaki.com'
assert message.subject == 'Sample mail'
assert message.to == 'mail@host.nl'
