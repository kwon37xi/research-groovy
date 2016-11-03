// DataSet : DB Table에 대한 추상화.
// 쿼리 생성기능 주의점 : 쿼리 생성 코드를 가진 Groovy Script 소스가 클래스패스에 있거나 그 자체가 groovy script로 실행돼야한다.


import groovy.sql.*

def db = Sql.newInstance("jdbc:mysql://localhost/groovy?useSSL=false", "root", "root", "com.mysql.jdbc.Driver")

db.execute "drop table if exists languages"
db.execute """
  create table languages (
    id integer not null auto_increment,
    name varchar(20) not null,
    primary key(id)
  )
"""

def languageSet = db.dataSet('languages') // languages 테이블에 대한 DataSet 생성
languageSet.add(id: null, name: 'Groovy',)

// 컬럼명을 명시하지 않으면 Null들어감
languageSet.add(name: 'Java')
languageSet.add(name: 'JRuby')
languageSet.add(name: 'Scala')

def result = []
// 전체 select 해서 iteration
languageSet.each {
    result << it.name
}
println "Result : ${result}"
assert 4 == result.size()
assert result == ['Groovy', 'Java', 'JRuby', 'Scala']

// 쿼리 생서기능 사용지점. sql_dataset.groovy 자체가 classpath에 들어가야함. 맨위에 package 구문을 빼야 script로 실행됨.
// 혹은 groovy --classpath '/path/to/mysql-connector-java.jar' sql_dataset.groovy
def firstItems = languageSet.findAll { it.id < 3 }.sort { it.name } // 쿼리만 생성되고 실행은 아직 안한상태.
assert 'select * from languages where id < ? order by name' == firstItems.sql
assert firstItems.parameters == [3]

// 진짜로 쿼리 실행
firstItems.findAll { it.name == 'Groovy' }.each { row ->
    assert 1 == row.id
    assert 'Groovy' == row.name
}