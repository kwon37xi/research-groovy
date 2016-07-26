package research.spock
/**
 *
 */
class Publisher {
    List<Subscriber> subscribers = new ArrayList<>()

    void add(Subscriber subscriber) {
        subscribers << subscriber
    }

    void send(String message) {
        subscribers.each { subscriber ->
            subscriber.receive(message)
        }
    }
}
