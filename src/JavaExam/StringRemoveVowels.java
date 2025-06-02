package JavaExam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringRemoveVowels {

	public static void main(String[] args) {
		String str = "Interview";
		String vowels = "aeiouAEIOU";

		for (int i = 0; i < str.length(); i++) {
			char v = str.charAt(i);

			if (!((vowels.indexOf(v)) != -1)) {
				System.out.println(v);
			}
			// Alternative way
//			if (vowels.contains(String.valueOf(v))) {
//				System.out.println(v);
//			}
		}

		// using Streams
		List<String> collect = Arrays.stream(str.split("")).filter(c -> !"AEIOUaeiou".contains(c)).distinct()
				.collect(Collectors.toList());
		System.out.println(collect);
	}
}
