package com.practice.streampapi;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class DuplicateString {

	public static void main(String[] args) 
	{
		List<String> list = Arrays.asList("Suman","Karan", "Suman", "Avishek");
		
		System.out.println("Input List: " + list);
		
		Set<String> noDuplicate = new HashSet<>();
		
		List<String> duplicate = list.stream().filter(l -> !noDuplicate.add(l))
								.toList();
		
		System.out.println("Duplicate Element: " + duplicate);
	}

}
