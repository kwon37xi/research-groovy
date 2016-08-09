package metaobject

class MetaClassExample {
    static void main(String[] args) {
        Student mst = new Student()
        println mst.getName()

        mst.metaClass.setAttribute(mst, 'name', 'Mark')
        println mst.getName()
    }

    static class Student {
        private String name = "Joe" // PRIVATE!!

        public String getName() {
            return this.name
        }
    }
}
