def course = [
        name: 'Groovy 101',
        teacher: 'mrhaki',
        location: 'The Netherlands'
]


assert course.toMapString(15) == '[name:Groovy 101, ...]'
assert course.toMapString(25) == '[name:Groovy 101, teacher:mrhaki, ...]'

def names = ['mrhaki', 'hubert']
assert names.toListString(5) == '[mrhaki, ...]'