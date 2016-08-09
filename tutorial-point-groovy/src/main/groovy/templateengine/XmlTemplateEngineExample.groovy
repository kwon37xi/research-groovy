package templateengine

import groovy.text.XmlTemplateEngine

/**
 * template과 그 결과가 XML일 때
 */
class XmlTemplateEngineExample {
    static void main(String[] args) {
        def binding = [StudentName: 'Joe', id: 1, subject: 'Physics']
        def engine = new XmlTemplateEngine()

        def text = '''\
   <document xmlns:gsp='http://groovy.codehaus.org/2005/gsp'>
      <Student>
         <name>${StudentName}</name>
         <ID>${id}</ID>
         <subject>${subject}</subject>
      </Student>
   </document>
'''
        def template = engine.createTemplate(text).make(binding)
        println template.toString() // 템플릿 문자열과 다른 새줄기호/공백등을 가진 XML이 생성된다.
    }
}
