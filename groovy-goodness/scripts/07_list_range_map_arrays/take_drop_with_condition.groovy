def s = 'Groovy Rocks!'

assert s.takeWhile { it != 'R' } == 'Groovy '
assert s.dropWhile { it != 'R' } == 'Rocks!'

def list = 0..10
assert 0..4 == list.takeWhile { it < 5 }
assert 5..10 == list.dropWhile { it < 5 }

def m = [name: 'mrhaki', loves: 'Groovy', worksAt: 'JDriven']

assert [name: 'mrhaki'] == m.takeWhile { key, value -> key.length() == 4 }
assert [loves: 'Groovy', worksAt: 'JDriven'] == m.dropWhile { it.key == 'name' }