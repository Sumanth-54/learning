package javaLearning;

//import java.util.List;
//import java.util.stream.IntStream;
//import java.util.stream.Collectors;
//
//public class SubarraySumStreams {
//	public static void findSubarrays(int[] arr, int S) {
//		IntStream.range(0, arr.length)
//				.forEach(start -> IntStream.range(start, arr.length)
//						.mapToObj(end -> List.of(arr).subList(start, end + 1))
//						.filter(subarray -> subarray.stream().mapToInt(Integer::intValue).sum() == S)
//						.forEach(System.out::println));
//	}
//
//	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3, 4 };
//		int S = 7;
//		findSubarrays(arr, S);
//	}
//}

import java.util.ArrayList;
import java.util.List;

public class SubarraySumStreams {
	public static void findSubarrays(int[] arr, int S) {
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			List<Integer> subarray = new ArrayList<>();

			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				subarray.add(arr[j]);

				if (sum == S) {
					System.out.println(subarray);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int S = 7;
		findSubarrays(arr, S);
	}
}
