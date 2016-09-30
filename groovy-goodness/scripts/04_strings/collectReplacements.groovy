def s = 'Gr00vy is gr8'

def replacement = {
    if (it == '8') {
        'eat'
    } else if (it == '0') {
        'o'
    } else {
        null
    }
}

assert s.collectReplacements(replacement) == 'Groovy is great'
println s.collectReplacements(replacement)