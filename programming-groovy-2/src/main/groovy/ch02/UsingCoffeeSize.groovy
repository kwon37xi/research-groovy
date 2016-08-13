package ch02

enum CoffeeSize {
    SHORT, SMALL, MEDIUM, LARGE, MUG
}

def orderCoffee(size) {
    print "Coffee order received for size $size"

    switch (size) {
        case [CoffeeSize.SHORT, CoffeeSize.SMALL]:
            println "you're health conscious"
            break
        case CoffeeSize.MEDIUM..CoffeeSize.LARGE:
            println "you gotta e a programmer"
            break;
        case CoffeeSize.MUG:
            println "you should try Caffeine IV"
            break;
    }
}

orderCoffee(CoffeeSize.SMALL)
orderCoffee(CoffeeSize.LARGE)
orderCoffee(CoffeeSize.MUG)

print 'Avaliable sizes are: '
for (size in CoffeeSize.values()) {
    print "$size "
}