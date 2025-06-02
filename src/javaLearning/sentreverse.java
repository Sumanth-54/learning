package javaLearning;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class sentreverse {
	public static void main(String[] args) {

		String s = "india is my country";

		String list = Arrays.stream(s.split(" ")).sorted(Collections.reverseOrder()).collect(Collectors.joining(" "));

		System.out.println(list);
	}

}
