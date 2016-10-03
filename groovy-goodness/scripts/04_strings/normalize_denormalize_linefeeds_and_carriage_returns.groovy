def text = 'First line\r\nSecond line\r\n' //windows line separator

def textNormalized = text.normalize()
def platformLS = System.properties['line.separator']

assert 'First line\nSecond line\n' == textNormalized
assert "First line${platformLS}Second line${platformLS}" == textNormalized.denormalize()

