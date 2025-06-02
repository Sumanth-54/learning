package javaLearning;

import java.util.List;
import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		 List<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");

		System.out.println("List: " + list); // Output: [Apple, Banana, Cherry]
	}
}
