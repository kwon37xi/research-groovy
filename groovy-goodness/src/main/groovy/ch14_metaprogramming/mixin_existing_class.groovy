package ch14_metaprogramming

import org.apache.commons.lang.StringUtils

class Parrot {
    static String speak(String text) {
        /Parrot says "$text"/
    }
}

String.mixin Parrot, StringUtils

assert 'mrhaki'.speak() == 'Parrot says "mrhaki"'
assert 'Groovy is so much fun.'.abbreviate(20) == 'Groovy is so much...'