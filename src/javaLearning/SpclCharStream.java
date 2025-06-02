package javaLearning;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpclCharStream {
	public static void main(String[] args) {

		String str = "Hell@@oo !! World";

		long collect = Arrays.stream(str.split("")).map(n -> n.charAt(0))
				.filter(n -> !Character.isLetterOrDigit(n) && !Character.isWhitespace(n)).count();
		System.out.println("Total Non-Special CharactersCount: " + collect);
		long count = str.chars().filter(s-> !Character.isLetterOrDigit(s)).count();
		System.out.println("Total  " + count);

		//using chars()
		String collect1 = str.chars().filter(n -> !Character.isLetterOrDigit(n) && !Character.isWhitespace(n))
				.mapToObj(n -> String.valueOf((char) n)).collect(Collectors.joining());
		System.out.println("Total Non-Special Characters: " +collect1);

		String input = "Hello@World!123#Java$Stream%^";

		// Count NON-special characters instead of special characters
		long nonSpecialCharCount = input.chars()
				.filter(ch -> !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)) // Only letters, digits,
																								// and
																								// spaces
				.count();

		System.out.println("Total Non-Special CharactersCount: " + nonSpecialCharCount);

		String nonSpecialCharDisplay = input.chars() // converts the string into a stream of int values, where each
														// integer represents the Unicode value of the characters in the
														// string. ex : H' -> 72, 'e' -> 101, etc...
				.filter(ch -> !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch))
				.mapToObj(c -> String.valueOf((char) c)) // converts the int values back into character strings. ex 64
															// -> "@"
				.collect(Collectors.joining());

		System.out.println("Total Non-Special Characters: " + nonSpecialCharDisplay);
	}
}
