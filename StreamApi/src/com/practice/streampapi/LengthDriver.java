package com.practice.streampapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LengthDriver {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("hii","I","am", "from", "Kolkata");
		
		System.out.println("Input list: " + list);
		
		List<Integer> output1 = list.stream().map(s -> s.length()).collect(Collectors.toList());
		
		System.out.println("Output1: " + output1);
		
		List<String> output2 = list.stream().filter(s -> s.length()>3).map(s -> s.toUpperCase()).toList();
		System.out.println("Output2: " + output2);
		
		List<String> output3 = list.stream().filter(s-> s.startsWith("K")).map(s -> s.toLowerCase()).toList();
		System.out.println("Output3: " + output3);
		
		long totalCount = list.stream().count();
		
		System.out.println("TotalCount: " + totalCount);
	}

}
