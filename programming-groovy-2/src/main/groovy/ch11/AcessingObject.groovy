def printInfo(obj) {
    userRequestedProperty = 'bytes' // getBytes() property
    userRequestedMethod = 'toUpperCase'

    println obj[userRequestedProperty]
    println obj."$userRequestedProperty"
    println obj."$userRequestedMethod"()
    println obj.invokeMethod(userRequestedMethod, null)
}

printInfo('hello')

println "Properties of 'hello' are: "
'hello'.properties.each {
    println "  > ${it}"
}