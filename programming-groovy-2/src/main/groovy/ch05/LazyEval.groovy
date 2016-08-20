package ch05

what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text

what.replace(0, 5, "moon")
println text

price = 684.71
company = 'Google'

quote = "Today $company stock closed at $price"
println quote

stocks = [Apple: 663.01, Microsoft: 30.95]

stocks.each { key, value ->
    company = key
    price = value
    println quote
}

println '-- with closure'
//companyClosure = { it.write(company)} // with it param
//priceClosure = { it.write("$price")} // with it param
companyClosure = { -> company } // without param
priceClosure = { -> price } // without param

quote = "Today ${companyClosure} stock closed at ${priceClosure}"
stocks.each { key, value ->
    company = key
    price = value
    println quote

}

quote = "-- with self-contained closure : Today ${-> company} stock closed at ${-> price}"
stocks.each { key, value ->
    company = key
    price = value
    println quote

}

