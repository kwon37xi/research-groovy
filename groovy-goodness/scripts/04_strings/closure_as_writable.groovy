// Closure.asWritable() -> Writable 객체 리턴. 여기에 toString() 도 구현돼 있음.

Writable make(Map binding = [:], Closure template) {
    // Use asWritable() to make the colsure
    // implement the Writable interface.
    def writableTemplate = template.asWritable()

    // Assign binding map as delegate so we can access
    // the keys of the maps as properties in the
    // closure context.

    writableTemplate.delegate = binding
    writableTemplate
}

// writable template은 Writer 를 인자로 받는듯.
assert make { Writer out -> out << 'Hello world!'}.toString() == 'Hello world!'

// Provide data for the binding
// The closure is not executed when the
// make method is finished
final writable = make(user: 'mrhaki', { out ->
    out.println "Welcome ${user},"
    out.print "Today on ${new Date(year: 114, month: 3, date: 4).format('yyyy-MM-dd')}, "
    out.println "we have a Groovy party!"
})

// We invoke toString() and now the closure is executed
final result = writable.toString()

assert result == '''Welcome mrhaki,
Today on 2014-04-04, we have a Groovy party!
'''

// Append contents to a file
// NOTE: The leftshift << operator on File is implemented
// in Groovy to use the File.append() method.

// The append() method creates a new Writer and
// invokes the write() method which
// is re-implemented in Groovy if the argument
// is a Writable object.
// Then the writeTo method is invoked:
// Writer.write(Writable) becomes Writable.writeTo(Writer).
// So alot of Groovy magic allows us to use the following one liner
// and still the writeTo() method is used on Writable
new File('/tmp/welcome.txt') << writable

assert new File('/tmp/welcome.txt').text == '''Welcome mrhaki,
Today on 2014-04-04, we have a Groovy party!
'''