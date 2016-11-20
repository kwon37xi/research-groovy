class Get {
    String url

    @Lazy URL urlObj = { url?.toURL() }()

    // soft=true : the field is soft reference
    @Lazy(soft = true) String text = urlObj?.text
}

def g = new Get(url: 'http://mrhaki.blogspot.com/')
assert 'http://mrhaki.blogspot.com/' == g.url
assert g.dump().contains('text=null') // text가 아직 초기화가 안됨.
assert g.dump().contains('urlObj=null') // urlObj 아직 초기화 안됨.

assert g.urlObj // 초기화
assert 'http' == g.urlObj.protocol
assert 'mrhaki.blogspot.com' == g.urlObj.host
assert '/' == g.urlObj.path

assert g.text // 초기화
assert g.text.contains('Hubert A. Klein Ikkink')