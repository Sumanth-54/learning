package javaLearning;

import java.util.HashSet;
import java.util.Set;

public class HastSetExample {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(10); // Duplicate, won't be added

		System.out.println("Set: " + set); // Output: [10, 20]
	}
}
