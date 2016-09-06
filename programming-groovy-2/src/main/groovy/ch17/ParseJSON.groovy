package ch17

import groovy.json.JsonSlurper

def slurper = new JsonSlurper()
def person = slurper.parse(new FileReader('person.json'))

println "$person.first $person.last is interested in ${person.sigs.join(', ')}"

Person realPerson = slurper.parse(new FileReader('person.json'))
println "${realPerson.getClass().name} - first: ${realPerson.first}, last: ${realPerson.last}, sigs: ${realPerson.sigs}, tools: ${realPerson.tools}"