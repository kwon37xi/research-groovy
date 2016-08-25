// package 구문이 있으면 compile을 해버려서 DataSet이 올바로 작동안함.

import groovy.sql.Sql
import groovy.xml.MarkupBuilder

import java.sql.Statement

def sql = Sql.newInstance('jdbc:mysql://localhost:3306/weatherinfo', 'root','', 'com.mysql.jdbc.Driver')

println sql.connection.catalog

println "City               Temparature"
sql.eachRow('SELECT * from weather') {
    printf "%-20s%s\n", it.city, it[1]
}

processMeta = { metaData ->
    metaData.columnCount.times { i ->
        printf "%-20s", metaData.getColumnLabel(i + 1)
    }
    println ""
}

sql.eachRow('SELECT * from weather', processMeta) {
    printf "%-20s%s\n", it.city, it[1]
}

rows = sql.rows('SELECT * from weather')
println "Weather info available for ${rows.size()} cities"

/**
 * withStatement를 해두면 쿼리 실행전에 Statement 객체를 가로채서 조작할 수 있다.
 */
println "=== withStatement stmt.maxRows = 3"
sql.withStatement { Statement stmt ->
    stmt.maxRows = 3
}
sql.eachRow('SELECT * from weather') {
    printf "%-20s%s\n", it.city, it[1]
}

sql.withStatement { stmt ->
    stmt.maxRows = 0 // 초기화
}

bldr = new MarkupBuilder()
bldr.weather {
    sql.eachRow('SELECT * from weather') {
        city(name: it.city, temperature: it.temperature)
    }
}

// java class로 compile 해서 실행시에는 작동 안함.
// http://stackoverflow.com/questions/18201213/ast-not-available-exception-while-filtering-dataset 참조
// 컴파일 되지 않은 groovy 소스가 존재하는 상태에서만 dataSet.findAll 이 작동한다고 한다.
dataSet = sql.dataSet('weather')
citiesBelowFreezing = dataSet.findAll {
    it.temperature < 32
}
println "Cities below freezing:"
citiesBelowFreezing.each {
    println it.city
}

println "Number of cities : " + sql.rows('SELECT * from weather').size()
//dataSet.add(city: 'Denver', temperature: 19)
println "Number of cities : " + sql.rows('SELECT * from weather').size()

temperature = 50
sql.executeInsert("""INSERT INTO weather (city, temperature)
    VALUES ('Oklahoma City', ${temperature})""")
println sql.firstRow("SELECT temperature from weather WHERE city='Oklahoma City'")