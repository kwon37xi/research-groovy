class PlayPerson2 {
    def work() { "working..." }

    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def methodMissing(String name, args) {
        System.out.println "methodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1]}

        if (methodInList) {
            def impl = { Object[] vargs ->
                "playing ${name.split('play')[1]}..."
            }

            PlayPerson2 instance = this
            instance.metaClass."$name" = impl // 미래의 요청은 methodMissing을 거치지 않고 메소드에 직접 가게 됨.
            impl(args)
        } else {
            throw new MissingMethodException(PlayPerson2.class, args)
        }
    }
}
jack = new PlayPerson2()
println jack.playTennis() // "methodMissing called for playTennis" 나옴.
println jack.playTennis() // "methodMissing called for playTennis" 안 나옴.