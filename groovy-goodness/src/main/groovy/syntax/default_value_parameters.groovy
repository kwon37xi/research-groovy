def say(msg = 'Hello', name = 'world') {
    "$msg $name!"
}

assert 'Hello world!' == say()

assert 'Hi world!' == say('Hi')
assert 'Howdy, mrhaki!' == say('Howdy,', 'mrhaki')