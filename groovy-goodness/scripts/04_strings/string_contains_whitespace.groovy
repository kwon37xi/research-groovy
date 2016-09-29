// 공백(tab, newline포함) 체크

assert ''.allWhitespace
assert '   '.allWhitespace
assert '\t '.allWhitespace
assert ' \r\n '.allWhitespace

assert !'mrhaki'.allWhitespace
