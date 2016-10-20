// OrderBy implements Comparator

class Language {
    String name
    boolean dynamic

    String toString() { "name: $name, dynamic: $dynamic" }
}

def languages = [
        new Language(name: 'Groovy', dynamic: true),
        new Language(name: 'Java', dynamic: false),
        new Language(name: 'Clojure', dynamic: true),
]

// dynamic -> name 순서로 정렬
def orderByDynamicAndName = new OrderBy([{ it.dynamic }, { it.name }])

def sortedLanguage = languages.sort(false, orderByDynamicAndName)
assert 'Java' == sortedLanguage[0].name
assert !sortedLanguage[0].dynamic

assert 'Clojure' == sortedLanguage[1].name
assert 'Groovy' == sortedLanguage[2].name
assert sortedLanguage[1].dynamic && sortedLanguage[2].dynamic