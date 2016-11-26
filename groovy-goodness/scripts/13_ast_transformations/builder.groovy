import groovy.transform.builder.Builder

// @Builder는 @Canonical 을 체크하여 @Canonical에서 include/exclude된 것들을 동일하게 처리한다.
@Builder
class Message {
    String from, to, subject, body
}

def message = Message.builder()
        .from('mrhaki@mrhaki.com')
        .to('mail@host.nl')
        .subject('Sample mail')
        .body('Groovy rocks!')
        .build()

assert message.body == 'Groovy rocks!'
assert message.from == 'mrhaki@mrhaki.com'
assert message.subject == 'Sample mail'
assert message.to == 'mail@host.nl'

@Builder(builderMethodName = 'initiator', buildMethodName = 'create')
class Message2 {
    String from, to, subject, body
}

def message2 = Message2.initiator()
        .from('mrhaki@mrhaki.com2')
        .body('Groovy rocks!2')
        .create()

assert message2.body == 'Groovy rocks!2'
assert message2.from == 'mrhaki@mrhaki.com2'

@Builder(prefix = 'assign')
class Message3 {
    String from, to, subject, body
}

def message3 = Message3.builder()
        .assignFrom('mrhaki@mrhaki.com')
        .assignBody('Groovy rocks!!!')
        .build()
assert message3.body == 'Groovy rocks!!!'
assert message3.from == 'mrhaki@mrhaki.com'

@Builder(excludes = 'body')
// or includes= 'from,to,subject'
class Message4 {
    String from, to, subject, body
}

def message4 = Message4.builder()
        // .body('hello') - compile error
        .from('mrhaki@mrhaki.com4')
        .to('mail@host.nl4')
        .subject('Groovy 2.3 is released')
        .build()

assert message4.from == 'mrhaki@mrhaki.com4'
assert message4.subject == 'Groovy 2.3 is released'

try {
    Message4.builder().body('Groovy rocks!').build()
    assert false, 'must not be here.'
} catch (MissingMethodException ex) {
    assert ex.message.readLines().first() == 'No signature of method: static Message4.body() is applicable for argument types: (java.lang.String) values: [Groovy rocks!]'
}
