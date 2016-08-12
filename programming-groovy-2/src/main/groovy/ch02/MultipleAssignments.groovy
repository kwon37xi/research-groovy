package ch02

def splitName(fullName) {
    fullName.split(' ')
}

def (firstName, lastName) = splitName('James Bond')

println "$lastName, $firstName $lastName"

def (name1, name2) = ["Thomson", "Thompson"]

println "$name1 and $name2"
(name1, name2) = [name2, name1]
println "$name1 and $name2"

def (String cat, String mouse) = ['Tom', 'Jerry', 'Spike', 'Tyke']
println "$cat and $mouse"

def (first, second, third) = ['Tom', 'Jerry']

println "$first, $second and $third"