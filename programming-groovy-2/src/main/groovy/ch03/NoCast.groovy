package ch03

import groovy.transform.TypeChecked

@TypeChecked
def use(Object instance) {
    if (instance instanceof String) {
        println instance.length() // no need to cast to String
    } else {
        println instance
    }
}

use('hello')
use(4)