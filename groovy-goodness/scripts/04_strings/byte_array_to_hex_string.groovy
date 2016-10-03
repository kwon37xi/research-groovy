final byte[] printable = [109, 114, 104, 97, 107, 105]
final byte[] nonprintable = [109, 114, 6, 27, 104, 97, 107, 105]

assert new String(printable) == 'mrhaki'
assert new String(nonprintable) == 'mr\u0006\u001Bhaki'

// encodeHex() returns a Writable
final Writable printableHex = printable.encodeHex()
assert printableHex.toString() == '6d7268616b69'
final nonprintableHex = nonprintable.encodeHex().toString()
assert nonprintableHex == '6d72061b68616b69'

// convert back

assert nonprintableHex.decodeHex() == nonprintable
assert printableHex.toString().decodeHex() == printable