package javaLearning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedCharacters {
	public static void main(String[] args) {
		String input = "programming";
		String input2 = "java java programming programming";

		// Count occurrences of each character
		Map<Character, Long> characterCount = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// Filter characters that appear more than once
		Map<Character, Long> repeatedCharacters = characterCount.entrySet().stream()
				.filter(entry -> entry.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		//using filter index
		Map<Object, Long> count = input.chars().mapToObj(c -> (char) c).filter(s -> input.indexOf(s) != input.lastIndexOf(s)).collect(Collectors.groupingBy(n->n, Collectors.counting()));
		System.out.println("RC " + count);
		System.out.println("Repeated characters: " + repeatedCharacters);

		// using split
		Map<String, Long> repeated = Arrays.stream(input2.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		System.out.println("Repeated : " + repeated);

		
		
		Map<Object, Long> collect = Arrays.stream(input2.split(" "))
				.filter(s -> input2.indexOf(s) != input2.lastIndexOf(s))
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));

		System.out.println(collect);
	}
}
