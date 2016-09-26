// With Groovy's "in" keyword we can check
// if an object is assignable for a class in the class hierarchy.

class Shape { }
class Circle extends Shape { }
class Square extends Shape { }

def square = new Square()

assert square in Shape
assert square in Square
assert !(square in Circle)

[Shape.class, Square.class].each {
    assert square in it
}