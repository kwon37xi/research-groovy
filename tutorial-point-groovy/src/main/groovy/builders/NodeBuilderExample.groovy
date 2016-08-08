package builders


class NodeBuilderExample {
    static void main(String[] args) {
        def nodeBuilder = new NodeBuilder()

        def students = nodeBuilder.userlist {
            user(id: '1', studentname: 'John', Subject: 'Chemistry')
            user(id: '2', studentname: 'Joe', Subject: 'Maths')
            user(id: '3', studentname: 'Mark', Subject: 'Physics')
        }

        println(students)
    }
}
