class ConnectedUser {
    String name
    def connections = []

    def speaks(args) { // args Map
        connections.find { it.name == args.to.name }.listen(args.saying)
    }

    def meets(user) {
        connections << user
    }

    def listen(text) {
        println "I, $name, am listening to '$text'"
    }

    def greeting() {
        "Hi, I am $name."
    }
}

def mrhaki = new ConnectedUser(name: 'mrhaki')
def hubert = new ConnectedUser(name: 'hubert')

mrhaki.meets hubert

println mrhaki.greeting()

mrhaki.speaks to: hubert, saying: 'How are you doing?'

def list = [1, 2, 3, 4]

println list.sum(100, { it * 2})

println list.sum(100) { it * 2}

sum = list.sum 100, { it * 2}
println sum