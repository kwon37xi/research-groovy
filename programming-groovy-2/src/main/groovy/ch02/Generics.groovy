package ch02


class Generics {
    static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>()

        list.add(1)
        list.add(2.0)
        list.add("Hello") // 컴파일이 이뤄지고 실행은 되지만 여기서 오류 발생.

        println "List populated"

        for (int element : list) {
            println(element)
        }
    }
}