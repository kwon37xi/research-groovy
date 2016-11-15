import groovy.json.*

def json = new JsonBuilder()

json.message {
    header {
        from('mrhaki')
        to 'Groovy Users', 'Java Users'
    }
    body "Check out Groovy's gr8 JSON support."
}

assert json.toString() == '{"message":{"header":{"from":"mrhaki","to":["Groovy Users","Java Users"]},"body":"Check out Groovy\'s gr8 JSON support."}}'

println JsonOutput.prettyPrint(json.toString())
println json.toPrettyString()
assert json.toPrettyString() == JsonOutput.prettyPrint(json.toString())