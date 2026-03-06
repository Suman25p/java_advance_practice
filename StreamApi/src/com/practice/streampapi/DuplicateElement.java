package com.practice.streampapi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElement {

	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(12,46,89,90,90,78,78);
		
		System.out.println("Input : " + list);
		
		Set<Integer> noDup = new HashSet<>();
		
		List<Integer> duplicate = list.stream().filter(n -> !noDup.add(n))
									.toList();
		
		System.out.println("Duplicate element: " + duplicate);
		
	}

}
