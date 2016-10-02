class Simple {
    String multi() {
        '''\
  Multiline string
  with simple 2 space indentation.'''
    }

    String multi173() {
        '''\
        Multiline string
        with simple 2 space
        indentation.'''.stripIndent()
    }
}

def multi = '''\
  Multiline string
  with simple 2 space
  indentation.'''

assert '''\
Multiline string
with simple 2 space
indentation.''' == multi.stripIndent()

assert '''\
ine string
imple 2 space
ation.''' == multi.stripIndent(8)
