/*
div() -> BigDecimal
intdiv() -> Integer
 */

def x = 26
def y = 10

def resultDiv = x.div(y)
def resultIntDiv = x.intdiv(y)

assert 2.6 == resultDiv
assert 2 == resultIntDiv

assert java.math.BigDecimal == resultDiv.class
assert java.lang.Integer == resultIntDiv.class