package ch08

languages = new XmlSlurper().parse("languages_ns.xml").declareNamespace(human: 'Natural')
print "Languages: "
println languages.language.collect { it.@name }.join(', ')
println "Natural languages: " + languages.'human:language'.collect { it.@name }.join(', ')

