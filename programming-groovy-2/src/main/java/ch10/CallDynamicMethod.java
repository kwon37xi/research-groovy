package ch10;

import groovy.lang.GroovyObject;

public class CallDynamicMethod {
    public static void main(String[] args) {
        GroovyObject instance = new DynamicGroovyClass();

        Object result1 = instance.invokeMethod("squeak", new Object[] {});
        System.out.println("received: " + result1);

        Object result2 = instance.invokeMethod("quack", new Object[] { "like", "a", "duck" });
        System.out.println("received: " + result2);
    }
}
