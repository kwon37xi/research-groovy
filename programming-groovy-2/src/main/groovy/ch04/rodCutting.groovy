package ch04

import groovy.transform.Immutable

def timeIt(length, closure) {
    long start = System.nanoTime()
    println "Max revenue for $length is ${closure(length)}"
    long end = System.nanoTime()

    println "Time taken ${(end - start)/1.0e9} seconds"
}

// 배열의 index가 length를 뜻하고 값이 가격을 의미함.
def rodPrices = [0, 1, 3, 4, 5, 8, 9, 11, 12, 14, 15, 15, 16, 18, 19, 15, 20, 21, 22, 24, 25, 24, 26, 28, 29, 35, 37, 38, 39, 40]
def desiredLength = 27 // $38

@Immutable
class RevenueDetails {
    int revenue
    ArrayList splits
}

def cutRod(prices, length) {
    if (length == 0) {
        new RevenueDetails(0, [])
    } else {
        def maxRevenueDetails = new RevenueDetails(Integer.MIN_VALUE, [])
        for (rodSize in 1..length) {
            def revenueFromSecondHalf = cutRod(prices, length - rodSize)
            def potentialRevenue = new RevenueDetails(prices[rodSize] + revenueFromSecondHalf.revenue, revenueFromSecondHalf.splits + rodSize)
            if (potentialRevenue.revenue > maxRevenueDetails.revenue) {
                maxRevenueDetails = potentialRevenue
            }
        }
        maxRevenueDetails
    }
}

def cutRodMemoize // 선언과 할당을 분리해야 closure 안에서 자기 자신을 재귀호출할 수 있음.
cutRodMemoize = { prices, length ->
    if (length == 0) {
        new RevenueDetails(0, [])
    } else {
        def maxRevenueDetails = new RevenueDetails(Integer.MIN_VALUE, [])
        for (rodSize in 1..length) {
            def revenueFromSecondHalf = cutRodMemoize(prices, length - rodSize)
            def potentialRevenue = new RevenueDetails(prices[rodSize] + revenueFromSecondHalf.revenue, revenueFromSecondHalf.splits + rodSize)
            if (potentialRevenue.revenue > maxRevenueDetails.revenue) {
                maxRevenueDetails = potentialRevenue
            }
        }
        maxRevenueDetails
    }
}.memoize()

//timeIt desiredLength, { length -> cutRod(rodPrices, length)}
timeIt desiredLength, { length -> cutRodMemoize(rodPrices, length)}

/*
memoize()는 Thread Safe.

memoize() : unlimited cache
memoizeAtMost() : 캐시 최대 크기 지정 LRU
memoizeAtLeast() : 캐시 최소크기 지정
memoizeAtLeastBetween() : 캐시 최소/최대 크기 지정
 */