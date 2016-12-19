// SimpleTemplateEngine  : 일반적으로
// GStringTemplateEngine : Streaming 필요할 때
// XmlTemplateEngine : for HTML, XML

import groovy.text.*

def simple = new SimpleTemplateEngine()
def source = '''Dear $name,
Please respond to this e-mail before ${(now + 7).format('yyyy-MM-dd')}
Kind regards, mrhaki'''

def binding = [now: new Date(109, 11, 1), name: 'Hubert Klein Ikkink']
def output = simple.createTemplate(source).make(binding).toString()

assert output == 'Dear Hubert Klein Ikkink,\n' +
        'Please respond to this e-mail before 2009-12-08\n' +
        'Kind regards, mrhaki'

def gstring = new GStringTemplateEngine()
def gsource = '''Dear <%= name %>
Text is created for <% if (gstring) out << 'GStringTemplateEngine' else out <<'other template engine'%>'''
def gbinding = [name: 'mrhaki', gstring: true]
def goutput = gstring.createTemplate(gsource).make(gbinding).toString()

assert goutput == 'Dear mrhaki\nText is created for GStringTemplateEngine'

def xmlEngine = new XmlTemplateEngine()
def xml = '''<?xml version="1.0"?>
<users xmlns:gsp="http://groovy.codehaus.org/2005/gsp">
    <gsp:scriptlet>users.each {</gsp:scriptlet>
        <user id="${it.id}">
            <gsp:expression>it.name</gsp:expression>
        </user>
    <gsp:scriptlet>}</gsp:scriptlet>
</users>    
'''

def xmlBinding = [users: [
        new Expando(id: 1, name: 'mrhaki'),
        new Expando(id: 2, name: 'Hubert')
]]

def xmlOutput = xmlEngine.createTemplate(xml).make(xmlBinding).toString()

/*
xmlOutput == '''<users>
  <user id='1'>
    mrhaki
  </user>
  <user id='2'>
    Hubert
  </user>
</users>'''
*/