// InitializerStrategy

import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

@Builder(builderStrategy = InitializerStrategy)
class Message {
    String from, to, subject, body
}

def message = Message.createInitializer()
        .from('mrhaki@mrhaki.com')
        .subject('Groovy 2.3 is released')

// 리턴 결과는 Message 객체가 아니라 Message$MessageInitializer 객체이다
assert !(message instanceof Message)
assert message.class.name == 'Message$MessageInitializer'

def messageInstance = new Message(message)

assert messageInstance instanceof Message
assert messageInstance.from == 'mrhaki@mrhaki.com'
assert messageInstance.subject == 'Groovy 2.3 is released'
