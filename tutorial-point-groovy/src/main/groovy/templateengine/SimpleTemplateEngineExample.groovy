package templateengine

import groovy.text.SimpleTemplateEngine

class SimpleTemplateEngineExample {
    static void main(String[] args) {
        def name = "Groovy"
        println "This Tutorial is about ${name}"

        def text = 'This Tutorial focuses on $TutorialName. In this tutorial you will learn about $Topic'

        def binding = ["TutorialName": "Groovy", "Topic": "Templates"]
        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(text).make(binding)

        println template

        def file = new File("tutorial-point-groovy/src/main/groovy/templateengine/student.template")
        binding = ['name': 'Joe', 'id': 1, 'subject': 'Physics']

        template = engine.createTemplate(file)
        def writable = template.make(binding)

        println writable
    }
}
