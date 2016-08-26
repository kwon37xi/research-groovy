package ch10

/**
 * Java method를 closure로 만들어 넘기는 방법.
 * http://www.jroller.com/melix/entry/coding_a_groovy_closure_in
 */
class Operation {
    def op(list, action) {
        list.each { action(it) }
    }
}
