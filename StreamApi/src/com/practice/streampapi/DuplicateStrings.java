package com.practice.streampapi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateStrings {

	public static void main(String[] args) {
	
		List<String> list = Arrays.asList("Suman","Deepali","Sanjay","Suman");
		
		System.out.println("Input List: " + list);
		
		Set<String> duplicate = new HashSet<>();
		
		List<String> unique = list.stream().distinct().toList();
		
		System.out.println("Unique Element: " + unique);

	}

}
