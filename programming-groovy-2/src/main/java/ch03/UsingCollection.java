package ch03;

import java.util.ArrayList;
import java.util.Collection;

public class UsingCollection {
    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>();
        Collection<String> col = lst;

        lst.add("one");
        lst.add("two");
        lst.add("three");

        lst.remove(0); // List.remove(int index)
        col.remove(0); // Collection.remove(Object) - 문제 지점.

        System.out.println("Added three items, removed two, so 1 item to remain.");
        System.out.println("Number of elements is : " + lst.size());
        System.out.println("Number of elements is: " + col.size());
    }
}
