package com.softtek;

import java.util.ArrayList;
import java.util.Collections;

class Employee {

	String name;
	int eno;

	Employee(String name, int eno) {
		this.name = name;
		this.eno = eno;
	}

	public String toString() {
		return eno + ":" + name;
	}

	public static void main(String[] args) {
		ArrayList<Employee> l = new ArrayList<Employee>();
		l.add(new Employee("Durga",100));
		l.add(new Employee("yaua",101));
		l.add(new Employee("venki", 102));
		
		Collections.sort(l,(e1,e2) -> (e1.eno<e2.eno)?-1:(e1.eno>e2.eno)?1:0);
		System.out.println(l);
		Collections.sort(l,(e1,e2) ->e1.name.compareTo(e2.name));
		System.out.println(l);

		
		
	}
	
}
