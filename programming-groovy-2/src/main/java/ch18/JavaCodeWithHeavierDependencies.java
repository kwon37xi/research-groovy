package ch18;

public class JavaCodeWithHeavierDependencies {
    public int someAction() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return (int) (Math.random() * 100);
    }

    public void myMethod() {
        int value = someAction() + 10;
        System.out.println(value);
    }
}
