package telran.set.tests;

import org.junit.jupiter.api.Test;

import telran.set.model.ISet;
import telran.set.model.MyHashSet;

class MyHashSetTest {

	@Test
	void test() {
ISet<String> mySet	= new MyHashSet<>();
System.out.println();
mySet.add("Boston");
mySet.add("Atlanta");
mySet.add("Chicago");

mySet.add("New York");
mySet.add("Detroit");
System.out.println(mySet.size());
mySet.add("Detroit");
System.out.println(mySet.size());
System.out.println(mySet.contains("Chicago"));
System.out.println(mySet.contains("Dallas"));
mySet.add("Dallas");
System.out.println(mySet.contains("Dallas")+" --");
System.out.println(mySet.size());
//System.out.println(mySet.remove("Dallas"));
System.out.println(mySet.size());
System.out.println(mySet.remove("Salem"));
System.out.println(mySet.size());
System.out.println(mySet.contains("Dallas"));
System.out.println("==========HW Iterator==");
for (String string : mySet) {
	System.out.println(string);
}
	}

}
