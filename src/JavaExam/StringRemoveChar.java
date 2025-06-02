package JavaExam;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringRemoveChar {
 public static void main(String[] args) {
	 String s = "Java learning";

	 String result = Arrays.stream(s.split(""))  // Split into characters
	         .filter(ch -> !ch.equalsIgnoreCase("a"))  // Filter out 'a' or 'A'
	         .collect(Collectors.joining());

	 System.out.println(result);  // Output: Jv
}
}
