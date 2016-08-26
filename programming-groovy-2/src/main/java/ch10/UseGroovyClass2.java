package ch10;

public class UseGroovyClass2 {
    public static void main(String[] args) {
        AGroovyClass instance = new AGroovyClass();

        System.out.println("Received: " + instance.passToClosure(2, new Object() {
            public String call(int value) {
                return "You called from Groovy with value " + value;
            }
        }));
    }
}
