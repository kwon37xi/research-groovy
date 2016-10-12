// findResults : 복수형. 결과중 null 이 아닌 것만 List로 뽑아냄.

def stuff = ['Groovy', 'Griffon', 'Gradle', 'Spock', 'Grails', 'GCntracts']

def stuffResults = stuff.findResults {
    it.size() == 6 ? "$it has 6 characters" : null
}

assert stuffResults == ['Groovy has 6 characters', 'Gradle has 6 characters', 'Grails has 6 characters']

def map = [what: 'Finish blog post', priority: 1, when: new Date()]
def mapResults = map.findResults {
    it.value instanceof String ? "Key $it.key is of type String" : null
}

assert mapResults == ['Key what is of type String']
