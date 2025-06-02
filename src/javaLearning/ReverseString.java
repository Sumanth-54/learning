package javaLearning;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List<String> reverse = Arrays.asList("Hello");

		String s = "Hello";

		String sorted = Arrays.stream(s.split("")).sorted(Collections.reverseOrder())
				.collect(Collectors.joining());
		System.out.println(sorted);

		//find the highest value...87665442
		List<Integer> numbers = Arrays.asList(8, 6, 7, 2, 4, 4, 6, 5);

		String largestNumber = numbers.stream().map(String::valueOf) // Convert to String
				.sorted((a, b) -> b.compareTo(a)) // Sort in descending order
				.collect(Collectors.joining()); // Join into a single string

		System.out.println("Largest Number: " + largestNumber);

	}

}
