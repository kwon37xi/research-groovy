// 기본적으로 owner == delegate

class Post {
    int count
    def info() {
        "This is Groovy Goodness post #$count!"
    }
}

count = 0
def info() {
    "Count value is $count."
}

def printInfo = {
    count++
    info()
}

// 현재 owner == delegate == script
assert "Count value is 1." == printInfo()

// delegate -> Post 객체로 변경
printInfo.resolveStrategy = Closure.DELEGATE_FIRST
printInfo.delegate = new Post(count: 100)

assert "This is Groovy Goodness post #101!" == printInfo()