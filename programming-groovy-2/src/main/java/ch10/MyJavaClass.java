package ch10;

import org.codehaus.groovy.runtime.MethodClosure;

import java.util.Arrays;

public class MyJavaClass {
    private Operation groovy = new Operation();

    private void shouldBeUsedAsClosure(String str) {
        System.out.println(str.toUpperCase());
    }

    private void shouldBeUsedAsClosure(int x) {
        System.out.println(x * x);
    }

    public void demonstrateClosureUsage() {
        MethodClosure cl = new MethodClosure(this, "shouldBeUsedAsClosure");
        groovy.op(Arrays.asList("hello", "world", "this", "should", "print", "4 : ", 2), cl);
    }

    public static void staticShouldBeUsedAsClosure(String str) {
        System.out.println(str.toLowerCase());
    }

    public void demonstrateStaticClosureUsage() {
        MethodClosure cl = new MethodClosure(MyJavaClass.class, "staticShouldBeUsedAsClosure");
        groovy.op(Arrays.asList("IT", "SHOULD", "BE", "LOWERCASE"), cl);
    }

    public static void main(String[] args) {
        MyJavaClass java = new MyJavaClass();
        java.demonstrateClosureUsage();
        java.demonstrateStaticClosureUsage();
    }

}
