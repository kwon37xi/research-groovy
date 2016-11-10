// XMLUtil
import groovy.xml.DOMBuilder
import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

def prettyXml = '''<?xml version="1.0" encoding="UTF-8"?><languages>
  <language id="1">Groovy</language>
  <language id="2">Java</language>
  <language id="3">Scala</language>
</languages>
'''

def xmlString = '<?xml version="1.0" encoding="UTF-8"?><languages><language id="1">Groovy</language><language id="2">Java</language><language id="3">Scala</language></languages>'
assert XmlUtil.serialize(xmlString) == prettyXml

def xmlOutput = new StringWriter()
XmlUtil.serialize(xmlString, xmlOutput)
println xmlOutput
assert xmlOutput.toString() == prettyXml

Node languagesNode = new XmlParser().parseText(xmlString)
assert  XmlUtil.serialize(languagesNode) == prettyXml

def languagesResult = new XmlSlurper().parseText(xmlString)
assert XmlUtil.serialize(languagesResult) == prettyXml


org.w3c.dom.Document doc = DOMBuilder.newInstance().parseText(xmlString)
org.w3c.dom.Element root = doc.documentElement
assert XmlUtil.serialize(root) == prettyXml

def languagesXml = {
    languages {
        language id: 1, 'Groovy'
        language id: 2, 'Java'
        language id: 3, 'Scala'
    }
}
def languageBuilder = new StreamingMarkupBuilder()
assert XmlUtil.serialize(languageBuilder.bind(languagesXml)) == prettyXml