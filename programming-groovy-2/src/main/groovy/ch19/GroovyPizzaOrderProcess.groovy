def dslDef = new File('GroovyPizzaDSL.groovy').text
def dsl = new File('orderPizza.dsl').text

def script = """
${dslDef}
acceptOrder {
    ${dsl}
}
"""

new GroovyShell().evaluate(script)
