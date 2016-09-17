// since groovy 1.6
def (username, email) = ['mrhaki', 'email@host.com']
assert 'mrhaki' == username
assert 'email@host.com' == email

int housenr
String streetname
(streetname, housenr) = ['Old Street', 42]
assert 42 == housenr
assert 'Old Street' == streetname

def iAmHere() {
    [29.20090, 12.90391]
}

def (coordX, coordY) = iAmHere()
assert coordX == 29.20090
assert coordY == 12.90391

def (a, b, c) = ['a', 'b', 'c', 'd'] // 변수 갯수보다 많은 값은 무시됨
assert 'a' == a
assert 'b' == b
assert 'c' == c

def (x, y, z) = [100, 200] // 변수 갯수가 더 많을 경우에는 넘치는 변수는 값설정 안됨.
assert 100 == x
assert 200 == y
assert !z

def money = '12 Euro'
def regexp = /(\d+) (\w+)/
def (exp, amount, currency) = (money =~ regexp)[0]
assert '12' == amount
assert 'Euro' == currency
