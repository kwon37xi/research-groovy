package metaobject

class MethodMissingExample {
    static void main(String[] args) {
        StudentForMethodMissing mst = new StudentForMethodMissing()
        mst.Name = "Joe"
        mst.ID = 1

        println(mst.Name)
        println(mst.ID)

        mst.AddMarks()
    }
}
