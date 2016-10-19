// grouping Collection -> map

class User {
    String name
    String city
    Date birthDate

    public String toString() { "$name" }
}

def users = [
        new User(name: 'mrhaki', city: 'Tilburg', birthDate: new Date(73, 9, 7)),
        new User(name: 'bob', city: 'New York', birthDate: new Date(63, 3, 30)),
        new User(name: 'britt', city: 'Amsterdam', birthDate: new Date(80, 5, 12)),
        new User(name: 'kim', city: 'Amsterdam', birthDate: new Date(83, 3, 30)),
        new User(name: 'liam', city: 'Tilburg', birthDate: new Date(109, 3, 6))
]

def userToString = { it.toString() }

// group by city
def usersByCity = users.groupBy { user -> user.city } // colosure가 리턴하는 값을 기준으로 grouping
assert 2 == usersByCity['Tilburg'].size()
assert ['mrhaki', 'liam'] == usersByCity['Tilburg'].collect(userToString)

assert ['bob'] == usersByCity['New York'].collect(userToString)
assert ['britt', 'kim'] == usersByCity['Amsterdam'].collect(userToString)

// group by year of birthdate
def byYear = { u -> u.birthDate[Calendar.YEAR] }
def usersByBirthDateYear = users.groupBy(byYear)

assert ['mrhaki'] == usersByBirthDateYear[1973].collect(userToString)

def groupByGroovy = {
    if (it =~ /y/) {
        "Contains y"
    } else {
        "Doesn't contain y"
    }
}

assert ["Contains y": ["Groovy"], "Doesn't contain y": ["Java", "Scala"]] == ['Groovy', 'Java', 'Scala'].groupBy(groupByGroovy)
