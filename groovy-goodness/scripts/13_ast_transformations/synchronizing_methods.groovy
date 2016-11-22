import groovy.transform.Synchronized

// @Synchronized
// 클래스에 lock 변수를 생성하고(혹은 존재하는 변수사용가능), 해당 변수로 락을 수행한다.
// 그냥 synchronized 키워드는 this 객체 전체를 lock해서 좋지 않다.

// 값을 변경했다가 다시 원복해도 다른 쓰레드에 영향을 전혀 안주는지 테스트
// @Synchronized를 제거하면 assert fail이 발생하지만 @Synchronized를 걸면, 모두 배타적으로 실행되기 때문에
// assert fail은 일어나지 않는다.
class Util {
    private counter = 0
    private def list = ['Groovy']

    private Object listLock = new Object[0]

    @Synchronized
    void workOnCounter() {
        println "${Thread.currentThread().name} workOnCounter"
        assert 0 == counter
        counter++
        assert 1 == counter
        sleep 5
        counter--
        assert 0 == counter
    }

    @Synchronized('listLock')
    void workOnList() {

        println "${Thread.currentThread().name} workOnList"
        assert 'Groovy' == list[0]
        list << 'Grails'
        assert 2 == list.size()
        sleep 5
        list = list - 'Grails'
        assert 'Groovy' == list[0]
        assert list.size() == 1
    }
}

def util = new Util()
def tc1 = Thread.start {
    100.times {
        util.workOnCounter()
        sleep 20
        util.workOnList()
        sleep 10
    }
}

def tc2 = Thread.start {
    100.times {
        util.workOnCounter()
        sleep 10
        util.workOnList()
        sleep 15
    }
}

tc1.join()
tc2.join()