package com.practice.streampapi;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class DuplicateElements {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(13,46,78,90,12,23,13,46,90);
		
		System.out.println("Input list: " + list);
		
		Set<Integer> noDuplicate = new HashSet<>();
		
		List<Integer> duplicate = list.stream().filter(l -> !noDuplicate.add(l)).toList();
		
		System.out.println("Duplicate Element: " + duplicate);
		
		List<Integer> unique = list.stream().distinct().toList();
		System.out.println("Unique Element: " + unique);

	}

}
