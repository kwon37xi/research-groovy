package ch10;

public class UseGroovyClass {
    public static void main(String[] args) {
        AGroovyClass instance = new AGroovyClass();

        Object result = instance.useClosure(new Object() { // closure object
            public String call() { // implement call
                return "You called from Groovy!";
            }
        });

        System.out.println("Received : " + result);
    }
}
