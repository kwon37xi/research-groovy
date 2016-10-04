// ~"pattern" => java.util.regex.Pattern
def single = ~'[ab]test\\d'
assert 'java.util.regex.Pattern' == single.class.name

def dubble = ~"string\$"
assert dubble instanceof java.util.regex.Pattern

def slashy = ~/slash \d+ value/
assert slashy instanceof java.util.regex.Pattern

def negateSlash = /${'hello'}GString$/.negate()
assert negateSlash instanceof java.util.regex.Pattern

def s = 'more'
def curlySlash = ~"$s GString"
assert curlySlash instanceof java.util.regex.Pattern

// Pattern.matcher() -> java.util.regex.Matcher
def testPattern = ~'t..t'
assert testPattern.matcher("test").matches()

// Groovy adds isCase() method to Pattern class
// Easy for switch and grep statements.
def p = ~/\w+vy/
assert p.isCase('groovy')

switch ('groovy') {
    case ~/java/: assert false; break;
    case ~/gr\w{4}/: assert true; break;
    default: assert false
}

// grep!
def lang = ~/^(?i)gr.*/
def languages = ['java', 'Groovy', 'gRails']
assert ['Groovy', 'gRails'] == languages.grep(lang)
