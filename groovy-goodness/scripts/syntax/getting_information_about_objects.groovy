// dump() : 객체의 이름, hashCode, 각 필드 값
// inspect() : 객체를 나타내는 문법과 비슷한 형태의 문자열

import groovy.xml.DOMBuilder

def map = [username: 'mrhaki']
assert "['username':'mrhaki']" == map.inspect()

def list = [1, 2, 3, 'Groovy']
assert "[1, 2, 3, 'Groovy']" == list.inspect()

def range = 0..10
assert '0..10' == range.inspect()

def str = 'Inspecting object with Groovy'
assert "'Inspecting object with Groovy'" == str.inspect()

def dom = DOMBuilder.newInstance().parseText('<root><language>Groovy</language></root>')
println dom.documentElement.inspect()
/*
<?xml version="1.0" encoding="UTF-8"?><root>
  <language>Groovy</language>
</root>
 */