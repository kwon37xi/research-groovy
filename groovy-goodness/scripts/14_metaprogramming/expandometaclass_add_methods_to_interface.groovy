// interface에도 metaClass가 있다.

interface Nothing { }

class Simple implements Nothing { }

Nothing.metaClass.groovyShoutOut = { -> 'Groovy is awesome!' }

def s = new Simple()
assert s.groovyShoutOut() == 'Groovy is awesome!'