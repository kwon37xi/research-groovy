import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy

// ExternalStrategy

class Message {
    String from, to, subject, body
}

@Builder(builderStrategy = ExternalStrategy, forClass = Message)
class MessageBuilder {}

def message = new MessageBuilder()
        .from('mrhaki@mrhaki.com')
        .to('mail@host.nl')
        .subject('Groovy 2.3 is released')
        .body('Groovy rocks!')
        .build()

assert message.body == 'Groovy rocks!'
assert message.from == 'mrhaki@mrhak.com'
assert message.subject == 'Groovy 2.3 is released'

@Builder(builderStrategy = ExternalStrategy, forClass = Message, prefix = 'assign', buildMethodName = 'create', includes = 'from,subject')
class MessageBuilder2 {}

def message2 = new MessageBuilder2()
    .assignFrom('mrhaki@mrhaki.com')
    .assignSubject('Groovy 2.3 is released')
    .create()

assert message.from == 'mrhaki@mrhaki.com'
assert message.subject == 'Groovy 2.3 is released'