// split(regex) -> String []
// tokenize(tokenchars) -> List<String>

def s= '''\
username;language,like
mrhaki,Groovy;yes
'''
assert s.split() instanceof String[]

// 기본적으로 whitespace로 split
assert ['username;language,like', 'mrhaki,Groovy;yes'] == s.split()

assert ['username', 'language', 'like', 'mrhaki', 'Groovy', 'yes'] == s.split(/(;|,|\n)/)

def result = []
s.splitEachLine(",") {
    result << it
}
assert ['username;language','like'] == result[0]
assert ['mrhaki', 'Groovy;yes'] == result[1]

assert s.tokenize() instanceof List

// 기본적으로 whitespace로 tokenize
assert ['username;language,like', 'mrhaki,Groovy;yes'] == s.tokenize()

assert ['username', 'language', 'like', 'mrhaki', 'Groovy', 'yes'] == s.tokenize("\n;,")