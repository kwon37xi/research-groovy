class PlayPerson {
    def work() { "working..." }

    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def methodMissing(String name, args) {
        System.out.println "methodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1]}
        if (methodInList) {
            "playing ${name.split('play')[1]}..."
        } else {
            throw new MissingMethodException(name, PlayPerson.class, args)
        }
    }
}

jack = new PlayPerson()

println jack.work()
println jack.playTennis()
println jack.playBasketBall()
println jack.playVolleyBall()
println jack.playTennis()

try {
    jack.playPolitics()
} catch (ex) {
    println "Error: " + ex\
}