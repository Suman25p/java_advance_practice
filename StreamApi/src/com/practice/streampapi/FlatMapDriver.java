package com.practice.streampapi;

import java.util.Arrays;
import java.util.List;

public class FlatMapDriver {

	public static void main(String[] args) {
		
		List<List<Integer>> input = Arrays.asList(
									Arrays.asList(12,23,67),
									Arrays.asList(5,2,6),
									Arrays.asList(10,20,60));
		System.out.println("Input: "  + input);
		
		List<Integer> output = input.stream().flatMap(num -> num.stream()).toList();
		System.out.println("Flatenning map: " + output);
		
		List<Integer> output2 = input.stream().flatMap(n -> n.stream()).filter(n -> n < 20)
								.map(n -> n * 10).toList();
		
		System.out.println("Result: " + output2);
		
	}

}
