package ch03

import groovy.transform.CompileStatic


@CompileStatic
def shout1(String str) {
    println str.toUpperCase()
}