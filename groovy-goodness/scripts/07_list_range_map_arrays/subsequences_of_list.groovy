def languages = ['Groovy', 'Clojure', 'Scala']
def sequences = languages.subsequences()

println sequences.inspect() // 결과가 HashSet
assert sequences == [['Groovy', 'Clojure', 'Scala'], ['Clojure', 'Scala'], ['Scala'], ['Clojure'], ['Groovy', 'Clojure'], ['Groovy', 'Scala'], ['Groovy']] as Set

assert [['Scala'], ['Clojure'], ['Groovy']] == sequences.findAll { it.size() == 1 } as List