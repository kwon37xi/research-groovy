package ch10_sql

import groovy.sql.*

def username = 'root', password = 'root', database = 'groovy', server = 'localhost'

def db = Sql.newInstance("jdbc:mysql://$server/$database?useSSL=false", username, password, 'com.mysql.jdbc.Driver')
// DataSource를 통해 만다는 것도 가능함.

db.execute "drop table if exists languages"
db.execute """
create table languages(
  id integer not null auto_increment,
  name varchar(20) not null,
  primary key(id)
)
"""

db.execute "insert into languages values(null, 'Groovy')"
assert 1 == db.updateCount // 총 갱신된 행수

// prepared statement 파라미터
db.execute 'insert into languages values(null, ?)', ['Java']
assert 1 == db.updateCount

// GString은 Prepared Statement가 된다.
def langValue = 'JRuby'
db.execute "insert into languages values(null, $langValue)"
assert 1 == db.updateCount

def insertedIds = db.executeInsert 'insert into languages values(null, "Scalaa")'
println insertedIds
assert 4 == insertedIds[0][0]

// executeUpdate는 updatedCount를 리턴한다.
def oldName = 'Scalaa', newName = 'Scala'
def updated = db.executeUpdate "Update languages set name=$newName where name=$oldName"
assert 1 == updated

// GroovyResultSet - column name으로 select 데이터 액세스 가능
def all = db.rows('select * from languages')
assert 4 == all.size()
println all
println all[0].getClass() // GroovyRowResult implements Map
assert ['Groovy', 'Java', 'JRuby', 'Scala'] == all.collect { it.name }
assert ['Groovy', 'Java', 'JRuby', 'Scala'] == all*.name
assert ['Groovy', 'JRuby'] == all.findAll { it.name =~ /y/ }.collect { it. name }


def maxId = 3
db.eachRow("select id, name from languages where id < $maxId") { row ->
    println "GroovyResultSet? ${row instanceof GroovyResultSet}"
    if (row.id == 1) assert 'Groovy' == row.name
    if (row.id == 2) assert 'Java' == row.name
}

db.eachRow("select name from languages where name=?", ['Java']) {
    assert 'Java' == it.name
}


def countRows = db.firstRow("select count(*) as numberOfRows from languages")
println "countRows instanceof ${countRows.getClass()}" // GroovyRowResult
assert 4 == countRows.numberOfRows
