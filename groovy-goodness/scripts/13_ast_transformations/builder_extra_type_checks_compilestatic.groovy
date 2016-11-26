// @CompileStatic 을 통해서 Builder에 지정된 모든 프라퍼티 값이 set 되었는지 컴파일 타임에 보장할 수 있다.
// InitializerStrategy


import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

@Builder(builderStrategy = InitializerStrategy, excludes = 'body', builderMethodName = 'creator')
class Message {
    String from, to, subject, body
}

@CompileStatic
def createMessage() {
    def messageInit = Message.creator()
            .from('mrhaki@mrhaki.com')
            .to('mail@host.nl')
            .subject('Groovy 2.3 is released')

    def message = new Message(messageInit)
    message
}

final Message message = createMessage()

assert message.from == 'mrhaki@mrhaki.com'
assert message.subject == 'Groovy 2.3 is released'
