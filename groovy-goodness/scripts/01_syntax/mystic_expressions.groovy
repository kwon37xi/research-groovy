result = []

def world(callable) {
    def result = callable()
    "Hello $result world!"
}

def say(Map map) {
    result << "Say '${map.hello}'"
}

// say([hello: world({'Groovy'})])
say hello:world {
    'Groovy'
}

// say([hello: world({'Java'})])
say hello:world {
    'Java'
}

assert "Say 'Hello Groovy world!'" == result[0]
assert "Say 'Hello Java world!'" == result[1]
