package ch07

def ticker = "ORCL"

println "Price for $ticker using static method is ${String.getPrice(ticker)}"
println "Price for $ticker using instance method is ${ticker.getPrice()}"