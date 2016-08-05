package xml

/**
 *
 */
class XmlParsingExample {
    static void main(String[] args) {
        def parser = new XmlParser()
        def doc = parser.parse("tutorial-point-groovy/movie.xml")

        // 최상위 노드인 collection 통하지 않고 그 자식 노드 찾기 가능.
        doc.movie.each { bk ->
            print("Movie Name: ${bk['@title']}\n")
            print("Movie Type: ${bk.type[0].text()}\n")
            print("Movie Format: ${bk.format[0].text()}\n")
            print("Movie year: ${bk.year[0].text()}\n")
            print("Movie rating: ${bk.rating[0].text()}\n")
            print("Movie stars: ${bk.stars[0].text()}\n")
            print("Movie description: ${bk.description[0].text()}\n")
            println("****************************************")
        }
    }
}
