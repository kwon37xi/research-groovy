/*
  spread operator(*)는 리스트를 단일 요소로 쪼개는 일을 한다.
  3개의 인자를 받는 메소드가 있을 때 3개의 요소를 가진 리스트에 *list 형태로 하나만 넘겨주면,
  자동으로 3개의 인자로 변경되어 메소드가 호출된다.
 */
class Simple {
    String speak(Integer n, String text, Date date) {
        def out = new StringBuilder()
        n.times { out << "Say $text on ${date.format('yyyy-MM-dd')}.\n"}
        out // automatically convert to String
    }
}

def params = [
        2,
        "hello world",
        Date.parse('yyyy/MM/dd', '2009/09/01')
]

// 메소드 호출 파라미터 변환
assert '''Say hello world on 2009-09-01.
Say hello world on 2009-09-01.
''' == new Simple().speak(*params) // params 리스트의 3개의 값이 각각 하나씩 파라미터 인자로 변환된다.

// List에 다른 리스트 요소 쉽게 추가
def list = ['Groovy', 'Java']
assert ['Groovy', 'Java', 'Scala'] == [*list, 'Scala'] // *list가 각각 별개의 요소로 쪼개지게 됨. 따라서 ['Groovy', 'Java', 'Scala']와 동일해짐.

def range = 2..5
assert [1, 2, 3, 4, 5, 6] == [1, *range, 6]

def map = [name: 'mrhaki', blog: true]
// map에 다른 map 쉽게 추가
assert [name: 'mrhaki', blog: true, subject: 'Groovy Goodness'] == [subject: 'Groovy Goodness', *:map]

// name parameter 흉내내는 트릭
// 메소드의 파라미터와 key/value 순서가 동일해야한다.
def paramsMap = [
        n: 1,
        text: 'hello',
        date: Date.parse('yyyy/MM/dd', '2009/09/04')
]

def paramsList = paramsMap.values().toList()
assert "Say hello on 2009-09-04.\n" == new Simple().speak(*paramsList)