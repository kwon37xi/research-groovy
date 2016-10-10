// upto(), downto()

def today = new Date().clearTime()
def nextWeek = today + 7

today.upto(nextWeek) {
    println it.format('EEEE')
}

println()

nextWeek.downto(today) {
    println it.format('EEEE')
}

def to = Calendar.instance
to.set year: 2013, month: Calendar.NOVEMBER, date: 18

def from = Calendar.instance
from.set year: 2013, month: Calendar.NOVEMBER, date: 13

from.upto(to) {
    if (it[Calendar.DATE]  % 2 == 0) {
        print 'Even'
    } else {
        print 'Odd'
    }
    println ' date'
}
