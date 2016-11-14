package ch12_xml_json

import groovy.text.markup.BaseTemplate
import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration

abstract class FontAwesomeTemplate extends BaseTemplate {

    FontAwesomeTemplate(MarkupTemplateEngine templateEngine, Map model, Map<String, String> modelTypes, TemplateConfiguration configuration) {
        super(templateEngine, model, modelTypes, configuration)
    }

    String icon(final String icon, final String[] attributes) {
        def faAttributes = attributes.collect { "fa-$it" }
        $/<span class="fa fa-${icon} ${faAttributes.join(' ')}"></span>/$
    }
}
