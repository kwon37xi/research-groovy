package ch18;

public class Car {
    private int miles;
    public int getMiles() {
        return miles;
    }
    public void drive(int dist) {
        if (dist < 0) {
            return;
        }
        miles += dist;
    }
}
