import java.text.MessageFormat as mf

assert 'Simple message!' == mf.format('Simple {0}!', ['message'] as Object[])

def intList = [1,2,3,4]
assert 'java.util.ArrayList' == intList.class.name
assert 4 == intList.size()

def intArray = intList as int[]
assert 'java.util.ArrayList' != intArray.class.name
assert 4 == intArray.length

def date = [109, 8, 6] as Date
assert 2009 == date[Calendar.YEAR]
assert 8 == date[Calendar.MONTH]
assert 6 == date[Calendar.DATE]

def t = new Thread({println 'hello'} as Runnable)
t.start()

def t2 = new Thread([run: { println 'hello'}] as Runnable)
t2.start()