
// use() closure마 마지막 statement가 리턴값이다.

class StringCategory {
    static String groovy(String self) {
        self + ' Yeah man.'
    }
}

def returnedValue = use(StringCategory) {
    def s = 'A simple String.'
    s.groovy()
}

assert returnedValue == 'A simple String. Yeah man.'