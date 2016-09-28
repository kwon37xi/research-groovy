// Groovy 1.8 $/.../$
// $/ 를 사용하면 / 를 escape하지 않아도 된다.

def source = 'Read more about "Groovy" at http://mrhaki.blogspot.com/'
def regexp = /.*"(.*)".*\/(.*)\//
def matcher = source =~ regexp
assert matcher[0][1] == 'Groovy'
assert matcher[0][2] == 'mrhaki.blogspot.com'

def regexpDollar = $/.*"(.*)".*/(.*)//$
def matcherDollar = source =~ regexpDollar
assert matcher[0][1] == 'Groovy'
assert matcher[0][2] == 'mrhaki.blogspot.com'

def multiline = $/
Also multilines
are supported
/$
println multiline