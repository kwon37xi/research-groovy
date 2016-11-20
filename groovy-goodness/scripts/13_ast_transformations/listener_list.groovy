import groovy.beans.ListenerList

// 컬렉션 필드는 Generic 이어야한다. 안그러면 올바른 코드가 생성될 수 없다.

interface TalkListener {
    void spoke(TalkEvent even)
}

class TalkEvent {
    String text, origin
}

class Speaker {
    @ListenerList
    List<TalkListener> talkListeners // Generic List

    String name

    void sayHello() {
        fireSpoke(new TalkEvent(origin: name, text: 'Hello Groovy World!'))
    }

    // @ListenerList가 자동으로 메소드 생성
    // void addTalkListener(TalkListener)
    // void removeTalkListener(TalkListener)
    // TalkListener[] getTalkListeners()
    // void fireSpoke(TalkEvent) : TalkListener.spoke를 따라 지어진 이름인듯.
}

def s = new Speaker(name: 'mrhaki')

s.addTalkListener([spoke: { event ->
    println "$event.origin says '${event.text.toLowerCase()}'"
}] as TalkListener)

def shouter = { event ->
    println "${event.text.toUpperCase()}"
} as TalkListener

s.addTalkListener shouter
s.sayHello()

/*
mrhaki says 'hello groovy world!'
HELLO GROOVY WORLD!
 */