package database

class ReadExample {
    static void main(String[] args) {
        def sql = DatabaseExample.createSql()

        sql.eachRow("select * from EMPLOYEE") { tp ->
            println([tp.FIRST_NAME, tp.LAST_NAME, tp.AGE, tp.SEX, tp.INCOME])
        }

        sql.close()
    }
}
