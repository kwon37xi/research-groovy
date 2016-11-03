// query()
// eachRow()

// name placeholder: :name, ?.id 형태
// 파라미터 값은 Map, Expando, 혹은 프라퍼티 이름이 파라미터와 일치하는 객체

// ordinal  named  : 1 기반.

import groovy.sql.*

def db = Sql.newInstance('jdbc:h2:mem:test', 'sa', '', 'org.h2.Driver')

db.execute '''
    create table if not exists languages (
        id int primary key,
        name varchar(20) not null
    )
'''
db.execute "insert into languages values(1, 'Groovy')"
db.execute "insert into languages values(2, 'Java')"

// == Ready for queries

def result = db.rows('select * from languages where name = :name', [name: 'Groovy'])
assert result[0] == [ID: 1, NAME: 'Groovy']

class QueryParams {
    String name = 'Java'
    Integer id = 2
}

result = db.rows('select * from languages where name = ?.name and id = :id', new QueryParams())
assert result[0] == [ID: 2, NAME: 'Java']

// ordinal named parameter
result = db.rows('select * from languages where name = ?1.name and id = ?2.id', [name: 'Groovy'], [id: 1])
assert result[0] == [ID: 1, NAME: 'Groovy']

result = db.rows('select * from languages where name = ?1.name and id = ?2.id', [name: 'Groovy'], new Expando([id: 1]))
assert result[0] == [ID: 1, NAME: 'Groovy']

result = db.rows('select * from languages where name = ?1.name or name = ?2.name', new QueryParams(), [name: 'Groovy'] )
assert result[0] == [ID: 1, NAME: 'Groovy']
assert result[1] == [ID: 2, NAME: 'Java']
