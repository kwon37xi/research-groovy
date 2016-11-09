// @WithWriteLock, @WithReadLock
// ReentrantReadWriteLock 대체.

import groovy.transform.*

class Bucket {
    final def items = []

    @WithWriteLock
    void add(String item) {
        items << item
    }

    @WithReadLock
    List getAllItems() {
        items
    }
}

def bucket = new Bucket()

def allThreads = []

3.times {
    allThreads << Thread.start {
        5.times {
            bucket.add Thread.currentThread().name + ': Groovy rocks'
            println "> ${Thread.currentThread().name} adds item to bucket."
            sleep 100
        }
    }

    allThreads << Thread.start {
        3.times {
            int numberOfItems = bucket.allItems.size()
            println "< ${Thread.currentThread().name} says $numberOfItems items are in the bucket."
            sleep 150
        }
    }
}

allThreads.each { it.join() }

assert bucket.items.size() == 15
println bucket.items