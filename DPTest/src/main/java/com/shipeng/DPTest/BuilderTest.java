package com.shipeng.DPTest;

import com.shipeng.BuilderPattern.Person;

public class BuilderTest {

	public static void main(String[] args) {
		
		Person person = new Person.PersonBuilder().build();
		System.out.println(person);
		
		Person person1 = new Person.PersonBuilder().setAge(18).setFirstName("Shipeng").setLastName("Xu").setIsMale(true).build();
		System.out.println(person1);
		
	} //end main
	
} //end class BuilderTest
