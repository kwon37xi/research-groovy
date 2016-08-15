package ch03

ArrayList<String> lst = new ArrayList<>();
Collection<String> col = lst;

lst.add("one");
lst.add("two");
lst.add("three");

lst.remove(0); // List.remove(int index)
col.remove(0); // Collection.remove(Object) 이지만 실제 구현체인 ArrayList.remove(int index)를 호출한다.

println("Added three items, removed two, so 1 item to remain.");
println("Number of elements is : " + lst.size());
println("Number of elements is: " + col.size());