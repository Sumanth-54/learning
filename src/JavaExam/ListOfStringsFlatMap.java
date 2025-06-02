package JavaExam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfStringsFlatMap {
	public static void main(String[] args) {

		List<String> str = Arrays.asList("ear", "cat", "bat");

		List<Character> collect = str.stream().flatMap(word -> word.chars().mapToObj(c -> (char) c)).distinct()
				.collect(Collectors.toList());
		System.out.println(collect);

		String[] input = { "ear", "cat", "bat" };

		List<String> output = Arrays.stream(input).flatMap(n -> n.chars().mapToObj(c -> String.valueOf((char) c)))
				.distinct()

				.collect(Collectors.toList());

		System.out.println(output);
	}
}
