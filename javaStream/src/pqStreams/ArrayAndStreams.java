package pqStreams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayAndStreams {

	public static void main(String[] args) {
		Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};
		
		System.out.printf("Original values: %s%n", Arrays.asList(values));
		
		System.out.printf("Sorted values: %s%n", Arrays.stream(values).sorted().collect(Collectors.toList()));
		
		System.out.printf("Printed values except [1-4] * 100: %s%n", Arrays.stream(values).filter(value -> value < 1 || value > 4).sorted((x,y) -> y-x).map(value -> value * 100).collect(Collectors.toList()));
		System.out.println();
		System.out.println();
		
		String[] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};
		
		System.out.printf("Original strings: %s%n", Arrays.asList(strings));
		
		System.out.printf("strings in uppercase: %s%n", Arrays.stream(strings).map(x->x.toUpperCase()).collect(Collectors.toList()));
		
	}

}
