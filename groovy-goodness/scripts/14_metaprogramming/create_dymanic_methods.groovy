// methodMissing을 구현하여 존재하지 않는 메소드에 대한 구현제공
// methodMissing은 성능이 떨어지지만 이를 metaClass에 캐싱하여 성능을 높일 수 있다.

class LanguageList {
    def list = ['Java', 'Groovy', 'Scala']

    LanguageList() {
        def mc = new ExpandoMetaClass(LanguageList, false, true)
        mc.initialize()
        this.metaClass = mc
    }

    def methodMissing(String name, args) {
        if (name.startsWith("find")) {
            def result = list.find { it == name[4..-1] }
            this.metaClass."$name" = {-> result + "[cache]"}
            result
        } else {
            throw new MissingMethodException(name, this.class, args)
        }
    }
}

def languages = new LanguageList()
assert languages.findGroovy() == 'Groovy'
assert languages.findScala() == 'Scala'
assert languages.findJava() == 'Java'
assert !languages.findRuby()

// 한 번 호출했기 때문에 그 뒤에는 캐쉬됨.
assert languages.findGroovy() == 'Groovy[cache]'
assert languages.findScala() == 'Scala[cache]'
assert languages.findJava() == 'Java[cache]'