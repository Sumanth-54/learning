package javaLearning;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");

		System.out.println("Map: " + map); // Output: {1=One, 2=Two, 3=Three}
	}
}
