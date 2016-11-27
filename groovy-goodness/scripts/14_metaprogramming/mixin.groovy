// mixin 기능은 trait 으로 대체되었다.

class Pirate {
    def talk(text) {
        "Aargh, walk the plank. ${text}"
    }
}

@Mixin(Pirate)
class Talk {}

assert new Talk().talk("Give me a bottle of rum.") == 'Aargh, walk the plank. Give me a bottle of rum.'

