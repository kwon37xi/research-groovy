// respondsTo : method availability
// hasProperty : property availability
// 동적 생성 여부는 알 수 없다.

class Simple {
    String language

    def whatDoYouSpeak() {
        language
    }

    def say(String text) {
        "You say $text in $language"
    }
}

def s = new Simple(language: 'Groovy')

assert s.metaClass.respondsTo(s, 'whatDoYouSpeak')
assert Simple.metaClass.respondsTo(s, 'say')
assert s.metaClass.respondsTo(s, 'say', String)
assert !s.metaClass.respondsTo(s, 'say', Integer)
assert Simple.metaClass.respondsTo(s, 'toString')

assert s.metaClass.hasProperty(s, 'language')
assert Simple.metaClass.respondsTo(s, 'getLanguage')
assert s.metaClass.respondsTo(s, 'setLanguage')