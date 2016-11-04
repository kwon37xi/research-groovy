// paging with rows(), eachRow()

import groovy.sql.Sql

def sql = Sql.newInstance('jdbc:h2:mem:test', 'sa', '', 'org.h2.Driver')

sql.execute '''
    create table if not exists languages (
        id integer not null auto_increment,
        name varchar(20) not null,
        primary key(id)
    )
'''

['Groovy', 'Java', 'Scala', 'JRuby', 'Clojure', 'Jython'].each {
    sql.execute "insert into languages(name) values($it)"
}

// offset 은 1부터 시작한다.
sql.eachRow('select * from languages', 1, 2) { row ->
    def expectedName = (row.id == 1 ? 'Groovy' : 'Java')
    assert row.name == expectedName
}

def result = sql.rows("select * from languages where name like 'J%'", 3, 3)
assert result.size() == 1
assert result[0].id == 6 && result[0].name == 'Jython'

sql.execute "drop table languages"
sql.close()