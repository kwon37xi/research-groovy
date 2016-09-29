def str = 'a1cB \n.9'
char[] characters = str.chars

assert characters[0].isLetter()
assert characters[1].isDigit()
assert characters[2].isLowerCase()
assert characters[3].isUpperCase()
assert characters[4].isWhitespace() // whitespace
assert characters[5].isWhitespace() // \n
assert !characters[6].isLetterOrDigit() // .
assert characters[7].isLetterOrDigit() // 9