def s = 'Argh, Groovy you say, mate?'

String encoded = s.bytes.encodeBase64().toString()
println encoded
assert 'QXJnaCwgR3Jvb3Z5IHlvdSBzYXksIG1hdGU/' == encoded
byte[] decoded = encoded.decodeBase64()
String decodedString = new String(decoded)
assert decodedString == s
println decodedString

String hex = s.bytes.encodeHex().toString()
assert '417267682c2047726f6f767920796f75207361792c206d6174653f' == hex
println hex
byte[] hexDecoded = hex.decodeHex()
String unhexed = new String(hexDecoded)
assert unhexed == s
println unhexed