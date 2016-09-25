// 객체에 구현된 call() 메소드를 객체명() 형태로 암시적으로 호출할 수 있다.

String.metaClass.call = { range -> delegate[range] } // stringobj[range] 호출

def groovyValue = 'Groovy is Gr8'
assert groovyValue(0) == 'G'
assert groovyValue(10) == 'G'
assert groovyValue(4) == groovyValue[4]
assert groovyValue.call(1) == groovyValue(1)
assert groovyValue(0..5) == 'Groovy'

class StringConverter {
    def value

    def value(s) {
        value = s
        this
    }

    def upper(cond) {
        value = value.collect { cond(it) ? it.toUpperCase() : it }.join()
    }

    def call(callable) {
        callable
    }
}

def converter = new StringConverter()
converter.with {
    value 'mrhaki' upper { it < 'm' }
    // groovyValue('mrhaki') upper { it < 'm' }
    // groovyValue('mrhaki').call(upper { it < 'm' })
    // groovyValue('mrhaki').call(upper({it < 'm'}))
}
assert converter.value == 'mrHAKI'

converter.with {
    value('jdriven') upper { it == 'j' || it == 'd'}
    assert value == 'JDriven'
}