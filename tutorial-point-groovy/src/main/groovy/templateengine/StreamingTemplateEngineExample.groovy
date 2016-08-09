package templateengine

import groovy.text.StreamingTemplateEngine

/**
 * StreamingTemplateEngine은 대용량 템플릿(64K 이상)을 처리할 수 있다.
 */
class StreamingTemplateEngineExample {
    static void main(String[] args) {
        def text = '''This Tutorial is <% out.print TutorialName %> The Topic name is ${TopicName}.'''
        def template = new StreamingTemplateEngine().createTemplate(text)

        def binding = [TutorialName: 'Groovy', TopicName: 'Templates']
        String response = template.make(binding)

        println(response)
    }
}
