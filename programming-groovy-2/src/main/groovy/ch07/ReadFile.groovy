package ch07

println new File('walden.txt').text

new File('walden.txt').eachLine { line ->
    println " > $line"
}

println new File('walden.txt').filterLine { it =~ /life/ }