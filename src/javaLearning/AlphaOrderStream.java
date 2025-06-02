package javaLearning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlphaOrderStream {
	public static void main(String[] args) {

		String str = "Java is fun and java is powerful";

		List<String> list = Arrays.stream(str.split(" ")).map(n -> n.toLowerCase()).distinct().sorted()
				.collect(Collectors.toList());
		System.out.println("Using Lambda " + list);

		List<String> list2 = Arrays.stream(str.split(" ")).map(String::toLowerCase).distinct().sorted()
				.collect(Collectors.toList());
		System.out.println("Using Method Reference: " + list2);

		
	}

}
