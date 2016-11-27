// Category 를 통해 기존 클래스에 메소드를 추가할 수 있다.

// 오직 use 블럭 안에서만 적용된다.


// static 메소드에 첫번째를 대상 클래스로 한 방식과
// @Category를 통해 일반 메소드로 구현하는 방식이 존재한다.

class Speak {
    static String shout(String text) {
        text.toUpperCase() + '!'
    }

    static String whisper(String text, boolean veryQuiet = false) {
        "${veryQuiet ? 'sssssssh' : 'sssh'}.. $text"
    }

    static String army(String text) {
        "$text. Sir, yes sir!"
    }
}

use (Speak) {
    assert "Pay attention".shout() == 'PAY ATTENTION!'
    assert 'Be vewy, vewy, quiet.'.whisper() == 'sssh.. Be vewy, vewy, quiet.'
    assert 'Be vewy, vewy, quiet.'.whisper(true) == 'sssssssh.. Be vewy, vewy, quiet.'
    assert 'Groovy rocks'.army() == 'Groovy rocks. Sir, yes sir!'
}

// 대상 객체를 this로 받음.
@Category(String)
class StreetTalk {
    String hiphop() {
        "Yo yo, here we go. ${this}"
    }
}

use(StreetTalk) {
    assert 'Groovy is fun!'.hiphop() == 'Yo yo, here we go. Groovy is fun!'
}

// 다른 Java class의 static 메소드를 사용할 수도 있음.
