package com.sofftek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment2 {

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		List<Integer> list = List.of(2, 2, 4, 6, 6, 8, 10, 12);

		List<String> string = List.of("Java", "Sql", "MongoDB", "Spring-Boot");
		
		Integer arr[] [] = {{1,2},{2,3,4},{7,8,9}};

		System.out.println("------------------------------------------------");

		System.out.println("-----Find the Minimum and maximum number of a Stream------");

		Integer min = list.stream().min((i1, i2) -> i1.compareTo(i2)).get();

		System.out.println(min);

		Integer max = list.stream().max((i1, i2) -> i1.compareTo(i2)).get();

		System.out.println(max);

		
		long count = string.stream().filter(s -> s.length() > 3).count();

		System.out.println(count);

		System.out.println("------------------------------------------------");

		System.out.println("---------Multiply 3 to all element in list and print the list-------");

		List<Integer> list2 = list.stream().map(s -> s * 3).collect(Collectors.toList());

		System.out.println(list2);

		System.out.println("------------------------------------------------");

		System.out.println("-----------To remove the duplicate elements from the list------------");

		List<Integer> list3 = list.stream().distinct().collect(Collectors.toList());

		System.out.println("List before removing Duplicate items:" + list);

		System.out.println("List after removing Duplicate items: " + list3);

		System.out.println("------------------------------------------------");

		System.out.println("Find the last element of a Stream in Java");

		Integer list4 = list.stream().reduce((i1, i2) -> i2).orElse(null);

		System.out.println(list4);

		System.out.println("------------------------------------------------");

		System.out.println("Count occurrence of a given character in a string ");

		String str = "Java is a High level lanaguage";
		
		long count2 = str.chars().filter(k -> k == 'a').count();
		
		System.out.println(count2);

		System.out.println("------------------------------------------------");

		System.out.println("Flatten a Stream of Arrays in Java using forEach loop");
	
		List<Integer> collect = Arrays.stream(arr).flatMap(t -> Arrays.stream(t)).collect(Collectors.toList());

		System.out.println(collect);
		
		System.out.println("------------------------------------------------");

		System.out.println("Program to convert IntStream to String in Java");
		
		

		System.out.println("------------------------------------------------");

		System.out.println("program to square the list of numbers and then filter out the numbers "
				+ "greater than 100 and then find the average of the remaining numbers");
		
		double double1 = list.stream().map( y -> y* 2).filter(y -> y<100).mapToInt(y ->y).average().getAsDouble();
		
		System.out.println(double1);
		
		System.out.println("------------------------------------------------");
		// Asc & dec
		// List<Integer> collect =
		// list5.stream().sorted((a,b)->-a.compareTo(b)).collect(Collectors.toList());
		// System.out.println(collect)

	}
}
