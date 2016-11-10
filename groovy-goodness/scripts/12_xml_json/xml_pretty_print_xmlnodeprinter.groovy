// groovy.util.Node 객체가 있을 경우
def xmlString = '<?xml version="1.0" encoding="UTF-8"?><languages><language id="1">Groovy</language><language id="2">Java</language><language id="3">Scala</language></languages>'

Node languages = new XmlParser().parseText(xmlString)

def xmlOutput = new StringWriter()
def xmlNodePrinter = new XmlNodePrinter(new PrintWriter(xmlOutput))
xmlNodePrinter.print(languages)

println xmlOutput.toString()
assert xmlOutput.toString() == '''<languages>
  <language id="1">
    Groovy
  </language>
  <language id="2">
    Java
  </language>
  <language id="3">
    Scala
  </language>
</languages>
'''

xmlOutput = new StringWriter()
xmlNodePrinter = new XmlNodePrinter(new PrintWriter(xmlOutput), " ") // indent
xmlNodePrinter.print(languages)
println xmlOutput.toString()
assert xmlOutput.toString() == '''<languages>
 <language id="1">
  Groovy
 </language>
 <language id="2">
  Java
 </language>
 <language id="3">
  Scala
 </language>
</languages>
'''

xmlOutput = new StringWriter()
xmlNodePrinter = new XmlNodePrinter(new PrintWriter(xmlOutput))
xmlNodePrinter.with {
    preserveWhitespace = true
    expandEmptyElements = true
    quote = "'"
}

xmlNodePrinter.print(languages)
println xmlOutput.toString()
assert xmlOutput.toString() == '''<languages>
  <language id='1'>Groovy</language>
  <language id='2'>Java</language>
  <language id='3'>Scala</language>
</languages>
'''