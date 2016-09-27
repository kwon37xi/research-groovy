/*
BigDecimal은 기본 import 되며, 숫자뒤에 G 혹은 g를 붙이면 BigDecimal(float/double)/BigInteger로 간주한다.
integer가 아닌 값은 기본이 BigDecimal이다.
 */
assert 123g instanceof BigInteger
assert 42G instanceof BigInteger
assert 1.423 instanceof BigDecimal
assert 42.0g instanceof BigDecimal
assert 9203.10291G instanceof BigDecimal

assert 3.2 == 1.2G + 2G
assert 10 == 10.1g - 0.1G
