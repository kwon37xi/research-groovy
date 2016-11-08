// Reader.transformLine(), Reader.transformChar()
def reader = new StringReader('''
Groovy's support
for transforming reader input to writer
output.
''')

def writer = new StringWriter()

reader.transformLine(writer) { String line ->
    if (line.matches(~/^Groovy.*/)) {
        line = '>>' + line.replaceAll('Groovy', 'GROOVY') + '<< '
    }
    line
}

def resultTransformLine = writer.toString()
println resultTransformLine

reader = new StringReader(resultTransformLine)
writer = new StringWriter()
reader.transformChar(writer) { ch ->
    ch in ['\n', '\r'] ? '' : ch
}

assert writer.toString() == ">>GROOVY's support<< for transforming reader input to writeroutput."