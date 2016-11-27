package ch14_metaprogramming

use(org.apache.commons.codec.digest.DigestUtils) {
    assert 'abc'.md5Hex() == '900150983cd24fb0d6963f7d28e17f72'
}