package database

import groovy.sql.Sql


class DatabaseExample {
    static void main(String[] args) {
        def sql = createSql()

        sql.eachRow('SELECT VERSION()') { row ->
            println "version ${row[0]}"
        }

        def sqlstr = """CREATE TABLE EMPLOYEE (
    FIRST_NAME CHAR(20) NOT NULL,
    LAST_NAME CHAR(20),
    AGE INT,
    SEX CHAR(1),
    INCOME FLOAT
)"""
        sql.execute(sqlstr)
        sql.close()
    }

    static Sql createSql() {
        Sql.newInstance('jdbc:mysql://localhost:3306/testdb', 'root', '', 'com.mysql.jdbc.Driver')
    }
}
