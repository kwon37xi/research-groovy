def b1 = false
def b2 = true
assert !b1
assert b2

def s1 = ''
def s2 = 'abc'

assert !s1
assert s2

def n1 = 0
def n2 = 42
assert !n1
assert n2

def l1 = []
def l2 = [1, 3, 6]
assert !l1
assert l2
def i1 = l1.iterator()
def i2 = l2.iterator()
assert !l1
assert l2
i2.next() // 1
assert i2
i2.next() // 3
assert i2
i2.next() // 6
assert !i2 // hasNext() == false

def m1 = [:]
def m2 = ['key': 'value']
assert !m1
assert m2

def o1
def o2 = new Expando(name: 'groovy')
assert !o1
assert o2

def ma1 = "groovy" =~ /java/
def ma2 = "groovy" =~ /groovy/
assert !m1
assert m2
