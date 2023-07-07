package com.softtek;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Runnable {

	public static void main(String[] args) {

//		String[] s = { "Nag", "Chiranjeevi", "Venkatesh", "Katrina" };
//		Predicate<String> p = s1 -> s1.length() > 5;
//		for (String s1 : s) {
//			if (p.test(s1)) {
//				System.out.println(s1);
//			}
//		}
//		Function<Integer, Integer>f = i ->i*i;
//		System.out.println(f.apply(4));
//		
//		Function<String, Integer> f= i ->i.length();
//		System.out.println(f.apply("Venki"));

		Function<Integer, Integer> f1 = i -> 2 * i;
		Function<Integer, Integer> f2 = i -> i * i * i;
		System.out.println(f1.andThen(f2).apply(2));
		System.out.println(f1.compose(f2).apply(2));

		Consumer<String> c = s -> System.out.println(s);
		c.accept("Durga");
		c.accept("Anahuta");

		Supplier<Date> s = () -> new Date();
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());

		BiPredicate<Integer, Integer> p = (a, b) -> (a + b) % 2 == 0;
		System.out.println(p.test(10, 21));
		System.out.println(p.test(15, 25));

//		IntFunction<Integer> f = i->i*i;
//		System.out.println(f.apply(4));

		IntToDoubleFunction f = i -> Math.sqrt(i);
		System.out.println(f.applyAsDouble(7));

		UnaryOperator<Integer> f11 = i -> i * i;
		System.out.println(f11.apply(4));

		IntUnaryOperator f3 = i -> i * i;
		System.out.println(f3.applyAsInt(4));

		BinaryOperator<String> f23 = (s1, s2) -> s1 + s2;
		System.out.println(f23.apply("durga", " " + "software"));

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(10);
		l.add(20);
		l.add(5);
		l.add(15);
		l.add(25);
		List<Integer> l1 = l.stream().filter(I -> I % 2 == 0).collect(Collectors.toList());
		System.out.println(l1);

		Integer[] i = l.stream().toArray(Integer[]::new);

		System.out.println("----------------------------");
		for (Integer i1 : i) {
			System.out.println(i1);
		}
		ArrayList<String> ll = new ArrayList<String>();
		ll.add("Sunny Leone");
		ll.add("Kajal Agarwal");
		ll.add("Prabhas");
		ll.add("Anushka Shetty");
		ll.add("Malika Sherawat");
		List<String> sortedList = ll.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println(sortedList);
		List<String> sortedList1 = ll.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());
		System.out.println(sortedList1);
		List<String> sortedList2 = ll.stream().sorted((s1, s2) -> -s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println(sortedList2);

		String s1 = new String("hello");
		String s2 = new String("hello");

		if (s1 == s2) {
			System.out.println("s1==s2 is TRUE");
		} else {
			System.out.println("s1==s2 is FALSE");
		}

		if (s1.equals(s2)) {
			System.out.println("s1.equals(s2) is TRUE");
		} else {
			System.out.println("s1.equals(s2) is FALSE");
		}

	}
}
