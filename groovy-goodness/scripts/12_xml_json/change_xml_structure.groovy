@Grapes(@Grab(group='xmlunit', module='xmlunit', version='1.3'))
import org.custommonkey.xmlunit.*
import groovy.xml.*

def xml = '''
<todo>
    <item priority="2">
        <title>Look into GPars</title>
    </item>
    <item priority="1">
        <title>Start developing Griffon App</title>
    </item>
    <item priority="2">
        <title>Grails 1.4 M1</title>
    </item>
    <item priority="3">
        <title>GWT Sample</title>
    </item>
</todo>
'''

def todo = new XmlSlurper().parseText(xml)

def items = todo.item.findAll { it.@priority.toInteger() < 3 }
items.each { item ->
    item.title = 'DO : ' + item.title // 바로 변경 적용
}

def gpars = todo.item.find { it.title =~ /.*GPars.*/ }
gpars.@priority = '1'  // 바로 변경 적용

todo.appendNode {
    item(priority: 2) {
        title 'Work on blog post'
    }
}

def grailsItem = todo.item.find {
    it.title.toString().contains('Grails')
}
grailsItem.replaceNode { node ->
    item(who: 'mrhaki', priority: node.@priority) {
        title 'Download Grails 1.4 M1'
    }
}

todo.item[3].replaceNode {} // 빈 노드로 교체 == 삭제

def newTodo = new StreamingMarkupBuilder().bind {
    mkp.yield todo
}.toString()

println newTodo

def expected = '''<?xml version="1.0" encoding="UTF-8"?><todo>
  <item priority="1">
    <title>DO : Look into GPars</title>
  </item>
  <item priority="1">
    <title>DO : Start developing Griffon App</title>
  </item>
  <item who="mrhaki" priority="2">
    <title>Download Grails 1.4 M1</title>
  </item>
  <item priority="2">
    <title>Work on blog post</title>
  </item>
</todo>
'''
XMLUnit.ignoreWhitespace = true
def difference = new Diff(newTodo, expected)
assert difference.identical()