def sampleText

def ternaryOutput = (sampleText != null) ? sampleText : 'Hello Groovy!'
println ternaryOutput

def elvisOutput = sampleText ?: 'Viva Las Vegas!'
println elvisOutput