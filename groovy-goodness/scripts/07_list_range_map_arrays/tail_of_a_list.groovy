// List.head() : 첫번째 항목
// List.tail() : 첫번째를 제외한 나머지 항목

def list = [1, 2, 3, 4]
def reverse(l) {
    if (l.size() == 0) {
        []
    } else {
        reverse(l.tail()) + l.head()
    }
}

assert [4, 3, 2, 1] == reverse(list)

assert [4, 3, 2, 1] == list.reverse()