package javaLearning;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatmapExample {

	    public static void main(String[] args) {
	        int[] num1 = {1, 2, 3, 4};
	        int[] num2 = {5, 6, 7, 8};

	        // Use flatMap to flatten the two arrays
	        int[] combined = Stream.of(num1, num2)  // Create a Stream of the arrays
	                               .flatMapToInt(Arrays::stream)  // Use flatMapToInt to flatten the stream of arrays
	                               .toArray();  // Collect the result into an array

	        // Print the combined result
	        System.out.println(Arrays.toString(combined));
	        
	        int[] array = Arrays.stream(num1).flatMap(n-> Arrays.stream(num2)).distinct().toArray();
	        System.out.println(array);
	    }
	}


