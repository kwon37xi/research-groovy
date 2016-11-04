// ResultSetMetaData
// rows(), eachRow() 에 ResultSetMetaData를 파라미터로 받는 closure를 넘긴다.
// rows(Map params, String sql, Closure metaClosure)
// eachRow(GString gstring, Closure metaClosure, Closure rowClosure)
import groovy.sql.*

import java.sql.ResultSetMetaData

def db = Sql.newInstance('jdbc:h2:mem:test', 'sa', '', 'org.h2.Driver')

db.execute '''
    create table if not exists languages (
        id int primary key,
        name varchar(20) not null
    )
'''
db.execute "insert into languages values(1, 'Groovy')"
db.execute "insert into languages values(2, 'Java')"


String query = 'select id as identifier, name as langName from languages'

db.rows(query, { ResultSetMetaData meta ->
    assert meta.getTableName(1) == 'LANGUAGES'
    assert meta.columnCount == 2
    assert meta.getColumnLabel(1) == 'IDENTIFIER'
    assert meta.getColumnName(1) == 'ID'
    assert meta.getColumnTypeName(1) == 'INTEGER'

    assert meta.getColumnLabel(2) == 'LANGNAME'
    assert meta.getColumnName(2) == 'NAME'
    assert meta.getColumnTypeName(2) == 'VARCHAR'
})