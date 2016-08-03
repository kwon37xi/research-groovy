package lists


class ListExample {
    static void main(String[] args) {
        println([11, 12, 13, 14])
        println([11, [12, 13], 14])
        println([])

        def list = [11, 12, 13, 14]
        def newlist = []

        newlist = list.minus([12, 13])
        println("old list " + list)
        println("newlist(minus) " + newlist)

        newlist = list.plus([15, 16])
        println("old list " + list)
        println("newlist(plus) " + newlist)

        println("pop " + list.pop())
        println("old list(popped) " + list)

        list = [13, 12, 15, 14]
        newlist = list.sort()

        println("old list(after sort) " + list) // sort affect original list
        println("newlist(sorted) " + newlist)

        newlist = list.reverse()
        println("old list(after reverse) : " + list) // reverse does NOT affect original list
        println("newlist(reversed) " + newlist)
    }
}
