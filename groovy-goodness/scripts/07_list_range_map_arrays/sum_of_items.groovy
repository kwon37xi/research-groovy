// sum() 은 요소의 plus() 메소드를 호출해서 결과를 만든다.

def numbers = [1, 2, 3, 4, 5, 6]
assert 21 == numbers.sum()
assert 31 == numbers.sum(10) // 초기값

class Product {
    String name
    BigDecimal price

    Product plus(Product other) {
        new Product(price: this.price + other.price)
    }
}

def products = [new Product(name: 'laptop', price: 999), new Product(name: 'netbook', price: 395)]

assert 1394 == products.sum().price

assert products.sum { it.price } == 1394
assert products.price.sum() == 1394 // spread operator
assert products*.price.sum() == 1394 // spread dot operator