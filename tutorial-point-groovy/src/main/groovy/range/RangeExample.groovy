package range


class RangeExample {
    static void main(String[] args) {
        println ">> 1..10 inclusive"
        (1..10).each {
            println(it)
        }

        println ">> 1..<10 exclusive"
        (1..<10).each {
            println(it)
        }

        println ">> 'a'..'x' char range"
        ('a'..'x').each {
            println(it)
        }

        println ">> 10..1 descending"
        (10..1).each {
            println(it)
        }

        println ">> 'x'..'a' descending"
        ('x'..'a').each {
            println(it)
        }

        def rint = 1..10
        println(rint.contains(2))
        println(rint.contains(11))

        println(rint.get(2))
        println(rint.get(4))

        println("from " + rint.getFrom() + ", to " + rint.getTo())

        println("(1..10).isReverse() : " + (1..10).isReverse())
        println("(10..1).isReverse() : " + (10..1).isReverse())

        println("(1..10).subList(1,4) : " + (1..10).subList(1,4))
        println("(1..10).subList(4,8) : " + (1..10).subList(4,8))
        println("(1..10).size() : " + (1..10).size())
    }
}
