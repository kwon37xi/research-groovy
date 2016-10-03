def ruler = (0..30).inject('\n') { result, c ->
    result += (c % 10)
}

def stringWithTabs = 'Groovy\tGrails\tGriffon'

println ruler
println stringWithTabs.expand() // default tab stop is 8
println stringWithTabs.expand(10)

assert 'Groovy  Grails  Griffon' == stringWithTabs.expand()
assert 'Groovy    Grails    Griffon' == stringWithTabs.expand(10)

def stringWithSpaces = 'Hubert  Klein   Ikkink'
def stringWithSpaces10 = 'Hubert    Klein     Ikkink'
println ruler
println stringWithSpaces
println stringWithSpaces10

println stringWithSpaces.unexpand() // default with 8
println stringWithSpaces10.unexpand(10)

assert 'Hubert\tKlein\tIkkink' == stringWithSpaces.unexpand()
assert 'Hubert\tKlein\tIkkink' == stringWithSpaces10.unexpand(10)