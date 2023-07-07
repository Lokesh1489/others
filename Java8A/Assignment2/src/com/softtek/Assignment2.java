package com.softtek;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Assignment2 {

	public static void main(String[] args) {

		System.out.println("Find minimum & maximum");
		List<Integer> list = List.of(2, 4, 8, 9, 4, 6);
		System.out.println(list);
		Integer min = list.stream().min((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println("The minimun number of the given list is :" + min);
		Integer max = list.stream().max((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println("The maximum number of the given list is :" + max);

		System.out.println("------------------------------------------------");
		System.out.println("Count Strings whose length is greater than 3 in List");
		List<String> list2 = List.of("lokesh", "loki", "lok", "lo", "l");
		System.out.println(list2);
		long count = list2.stream().filter(s -> s.length() > 3).count();
		System.out.println("Strings whose length is greater than 3 is :" + count);

		System.out.println("------------------------------------------------");
		System.out.println("Multiply 3 to all element in the list");
		List<Integer> list3 = List.of(3, 7, 2, 8, 9);
		System.out.println(list3);
		List<Integer> numbers = list3.stream().map(i -> i * 3).collect(Collectors.toList());
		System.out.println("Multiply 3 to all elements in the list is :" + numbers);

		System.out.println("------------------------------------------------");
		System.out.println("Remove the duplicate elements in the list");
		List<Integer> list4 = List.of(14, 18, 38, 65, 14, 45, 18, 38);
		System.out.println(list4);
		List<Integer> Afterremoved = list4.stream().distinct().collect(Collectors.toList());
		System.out.println("After Removing the duplicate elements in the list is :" + Afterremoved);

		System.out.println("------------------------------------------------");
		System.out.println("Find the last element of a Stream in given list");
		List<Integer> list5 = List.of(14, 18, 38, 65, 14, 45, 18, 38);
		System.out.println(list5);
		Integer lastelement = list5.stream().reduce((i1, i2) -> i2).orElse(null);
		System.out.println("The last element of a given Stream is :" + lastelement);

		System.out.println("------------------------------------------------");
		System.out.println("Count occurrence of a given character in a string ");
		String str = "Java is a High level lanaguage";
		System.out.println("Java is a High level lanaguage");
		long count2 = str.chars().filter(k -> k == 'a').count();
		System.out.println("Count occurrence of a given character in a string is :" + count2);

		System.out.println("------------------------------------------------");
		System.out.println("Flatten a Stream of Arrays in Java using forEach loop");
		Integer arr[][] = { { 1, 2 }, { 2, 3, 4 }, { 7, 8, 9 } };
		List<Integer> collect = Arrays.stream(arr).flatMap(t -> Arrays.stream(t)).collect(Collectors.toList());
		System.out.println("Flatten a Stream of Arrays in Java using forEach loop is " + collect);

		System.out.println("------------------------------------------------");
		System.out.println("To convert intStream to String");
		IntStream stream = IntStream.of(7, 0, 1, 9, 3, 9, 2, 9, 2, 2);
		System.out.println("String: " + stream.mapToObj(String::valueOf).collect(Collectors.joining("-")));

		System.out.println("------------------------------------------------");
		System.out.println("program to square the list of numbers and then filter out the numbers "
				+ "greater than 100 and then find the average of the remaining numbers");
		List<Integer> list6 = List.of(4, 81, 3, 6, 5);
		double double1 = list6.stream().map(y -> y * 2).filter(y -> y < 100).mapToInt(y -> y).average().getAsDouble();
		System.out.println(double1);
	}

}
