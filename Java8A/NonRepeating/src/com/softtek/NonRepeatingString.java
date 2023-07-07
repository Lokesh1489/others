package com.softtek;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class NonRepeatingString {

	public static void findNonRepeated(String rt) {
		Optional<Character> NonRepeat = rt.toLowerCase().chars() // initially it converts the given string to lower case
				.mapToObj(s -> (char) s) // Creating a Stream of Strings,Stream map to Obj
				.filter(c -> (rt.indexOf(c)) == rt.lastIndexOf(c)).findFirst();
		// Initial index of character will compare with last index of that particular
		System.out.println(NonRepeat.get());
	}

	public static void main(String[] args) {
		findNonRepeated("jajajjppgq");

		LocalDate date = LocalDate.now();
		System.out.println(date);
		int dd = date.getDayOfMonth();
		int mm = date.getMonthValue();
		int yyyy = date.getYear();
		System.out.println(dd + "-" + mm + "-" + yyyy);
		System.out.printf("%d-%d-%d", dd, mm, yyyy);
		LocalDateTime dt = LocalDateTime.of(1999, 06, 14, 12, 06);
		System.out.println(dt);
		LocalDate birthday = LocalDate.of(1999, 06, 14);
		LocalDate today = LocalDate.now();
		Period p = Period.between(birthday, today);
		System.out.printf("Age is %d Years %d months %d days", p.getYears(), p.getMonths(), p.getDays());

//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the year");
//		int n = sc.nextInt();
//		Year y = Year.of(n);
//		if(y.isLeap())
//		{
//			System.out.printf("%d year is leap year",n);
//		}
//		else {
//			System.out.println("%d year is not leap year");
//		}
//	
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);

//		ZoneId la = ZoneId.of("America /Los-Angeles");
//		ZonedDateTime zt = ZonedDateTime.now(la);
//		System.out.println(zt);

		ArrayList<Integer> l = new ArrayList<>();
		l.add(20);
		l.add(10);
		l.add(25);
		l.add(5);

		System.out.println(l);
		Comparator<Integer> c = (i1, i2) -> (i1 < i2) ? -1 : (i1 > i2) ? 1 : 0;
		Collections.sort(l,c);
		System.out.println(l);
		
		
		
	}

}
