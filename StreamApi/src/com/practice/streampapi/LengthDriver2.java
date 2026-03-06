package com.practice.streampapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LengthDriver2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12,89,80,378,90,13,1);
		
		System.out.println("Input: " + list);
		
		List<Integer> output = list.stream().filter(n -> n <89).map(n -> n* 2).collect(Collectors.toList());
		System.out.println("Result: " + output );
	}

}
