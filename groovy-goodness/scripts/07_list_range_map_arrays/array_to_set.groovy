// array를 toSet() 으로 Set으로 바꾸면서 중복 요소 제거
def numbers = [1, 2, 1, 4, 1, 2] as int[]
assert numbers.toSet() == [1, 2, 4] as Set

def list = ['Groovy', 'Java', 'Grails', 'Groovy']
assert list.toSet() == ['Groovy', 'Java', 'Grails'] as Set
