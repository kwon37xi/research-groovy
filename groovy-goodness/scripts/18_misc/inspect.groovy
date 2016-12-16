import groovy.xml.DOMBuilder
import org.w3c.dom.Document
import org.w3c.dom.Element

// 모든 객체에서 inspect() 가능.
// toString과 비슷하지만 포맷이 더 강화됨. 거의 Groovy 문법 형태로 보여줌.

def username = 'mrhaki'
assert username.inspect() == "'mrhaki'"
assert username.toString() == "mrhaki"

def user = "${username}" // GString
assert user.inspect() == "mrhaki"

def multiline = '''Hello mrhaki,
how you're doing?'''
assert multiline.inspect() == /'Hello mrhaki,\nhow you\'re doing?'/


def list = [42, '1', ['Groovy rocks!']]
assert list.inspect() == "[42, '1', ['Groovy rocks!']]"

def range = 21..<24
assert range.inspect() == '21..<24'

def m = [a: 1, b: '1']
assert m.inspect() == "['a':1, 'b':'1']"

def xmlString = '<root><contents>mrhaki</contents></root>'
Document doc = DOMBuilder.newInstance().parseText(xmlString)
Element root = doc.documentElement.firstChild
assert root.inspect().trim() == '<?xml version="1.0" encoding="UTF-8"?><contents>mrhaki</contents>'