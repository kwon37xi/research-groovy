// permutation : 치환, 순열, 변경
// permutation 은 여기서 해당 컬렉션의 모든 항목으로 만들 수 있는 모든 조합을 뜻한다.
def languages = ['Groovy', 'Clojure', 'Scala']

def result = []

languages.eachPermutation {
    result << it
}

println result // [[Groovy, Clojure, Scala], [Groovy, Scala, Clojure], [Clojure, Groovy, Scala], [Clojure, Scala, Groovy], [Scala, Groovy, Clojure], [Scala, Clojure, Groovy]]

assert 6 == result.size()
assert ['Groovy', 'Clojure', 'Scala'] == result[0]
assert ['Groovy', 'Scala', 'Clojure'] == result[1]

assert [['Clojure', 'Groovy', 'Scala'], ['Clojure', 'Scala', 'Groovy']] == result.findAll { it[0] == 'Clojure' }

def list = [true, false]
def permutations = list.permutations()
println permutations // [[true, false], [false, true]]
assert 2 == permutations.size()
assert [[false, true], [true, false]] as Set == permutations
