// Map 으로 파라미터 만들어 전달가능해짐.

// connectionTimeout in millis
// readTimeout in millis
// useCaches
// allowUserInteraction
// requestProperties

def url = "http://www.mrhaki.com".toURL()
Integer.metaClass.getSeconds = { -> delegate * 1000 }

def content = url.getText(connectTimeout: 10.seconds, readTimeout: 10.seconds, useCaches: true, allowUserTransaction: false, requestProperties: ['User-Agent': 'Groovy Sample Script'])

assert content.contains("Hello. I am a passionate Groovy and Java developer based in Tilburg")

url.newReader(connectTimeout: 10.seconds, useCaches: true).withReader { reader ->
    reader.readLines().each { println it }
}