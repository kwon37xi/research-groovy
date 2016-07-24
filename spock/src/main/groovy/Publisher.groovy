/**
 *
 */
class Publisher {
    List<Subscriber> subscribers = new ArrayList<>()

    void add(Subscriber subscriber) {
        subscribers << subscriber
    }

    void fire(String message) {
        subscribers.each { subscriber ->
            subscriber.receive(message)
        }
    }
}
