// URL.text
def url = "http://www.mrhaki.com/".toURL()

assert  url.text.contains("Hello. I am a passionate Groovy and Java developer based in Tilburg, The Netherlands.")

def result = []
url.eachLine {
    if (it =~ /Groovy/) {
        result << it
    }
}
result.each { println it }


url.withReader { reader ->
    reader.readLines().each {
        println it
    }
}