// intersect : 교차하다. 교집합.
// disjoint : 교집합이 없는지 여부

def one = ['Java', 'Groovy', 'Scala']
def two = ['Groovy', 'JRuby', 'Java']
def three = ['C++', 'C#']

assert ['Groovy', 'Java'] == one.intersect(two)
assert one.disjoint(three) // 교집합 없다~
assert !one.disjoint(two) // 교집합 있다~

