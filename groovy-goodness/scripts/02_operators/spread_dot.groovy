// *. operator is used to invoke a method on all members of Collection object. -> result is another Collection

class Language {
    String lang
    def speak() { "$lang speaks."}
}

def list = [
        new Language(lang: 'Groovy'),
        new Language(lang: 'Java'),
        new Language(lang: 'Scala')
]

assert ['Groovy speaks.', 'Java speaks.', 'Scala speaks.'] == list*.speak()

assert ['Groovy speaks.', 'Java speaks.', 'Scala speaks.'] == list.collect { it.speak() } // collect == Stream.map

// 리스트의 각 요소의 프라퍼티 접근
assert ['Groovy', 'Java', 'Scala'] == list*.lang
// 그러나 *. 없이 . 으로 바로 접근가능
assert ['Groovy', 'Java', 'Scala'] == list.lang