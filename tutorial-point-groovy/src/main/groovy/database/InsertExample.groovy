package database


class InsertExample {
    static void main(String[] args) {
        def sql = DatabaseExample.createSql()

        sql.connection.autoCommit = false

        def firstname = "Mac"
        def lastname = "Mohan"
        def age = 20
        def sex = "M"
        def income = 2000

        def sqlstr = "INSERT INTO EMPLOYEE(FIRST_NAME,LAST_NAME, AGE, SEX, INCOME) VALUES(${firstname}, ${lastname}, ${age}, ${sex}, ${income})"

        try {
            sql.execute(sqlstr)
            sql.commit()
            println "Successfully committed"
        } catch (Exception ex) {
            sql.rollback()
            println("Transaction rollback")
            ex.printStackTrace()
        }

        sql.close()
    }
}
