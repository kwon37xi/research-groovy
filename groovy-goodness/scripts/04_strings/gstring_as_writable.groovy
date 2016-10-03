def data = [
        new Expando(id: 1, user: 'mrhaki', country: 'The Netherlands'),
        new Expando(id: 2, user: 'hubert', country: 'The Netherlands')
]

data.each { userData ->
    new File("/tmp/${userData.id}.txt").withWriter('UTF-8') { fileWriter ->
        "User $userData.user lives in $userData.country".writeTo(fileWriter)
    }
}

assert new File('/tmp/1.txt').text == 'User mrhaki lives in The Netherlands'
assert new File('/tmp/2.txt').text == 'User hubert lives in The Netherlands'