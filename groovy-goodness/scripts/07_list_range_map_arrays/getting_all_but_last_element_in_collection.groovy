// Groovy 2.4 init() : 마지막을 제외한 모든 요소 리턴

def gr8Tech = ['Groovy', 'Grails', 'Spock', 'Gradle', 'Griffon']

assert gr8Tech.init() == ['Groovy', 'Grails', 'Spock', 'Gradle']
assert gr8Tech.last() == 'Griffon'

assert gr8Tech.head() == 'Groovy'
assert gr8Tech.tail() == ['Grails', 'Spock', 'Gradle', 'Griffon']
