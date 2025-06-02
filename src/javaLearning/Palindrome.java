package javaLearning;

public class Palindrome {

	public static void main(String[] args) {

		String s = "My name is nitin I know malayalam";
		String[] words = s.split(" ");

		for (String word : words) {
			if (isPalindrome(word)) {
				System.out.println(word);
			}
		}

	}

	public static boolean isPalindrome(String s) {
		int s1 = 0;
		int s2 = s.length() - 1;

		while (s2> s1) {
			if (s.charAt(s1) != s.charAt(s2)) {
				return false;
			}
			s1++;
			s2--;
		}
		return true;

	}

}
