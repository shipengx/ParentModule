package com.shipeng.BuilderPattern;

public class Person {
	private final String firstName;
	private final String lastName;
	private final int age;
	private final boolean isMale;
	
	public Person(
	    final String firstName,
	    final String lastName,
	    final int age,
	    final boolean isMale) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.isMale = isMale;
	}
		
	public static class PersonBuilder {
		private String firstName;
		private String lastName;
		private int age;
		private boolean isMale;
		
		public PersonBuilder() {
		}
			
		public PersonBuilder(
			final String firstName,
			final String lastName,
			final int age,
			final boolean isMale) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.isMale = isMale;
		}
			
		public PersonBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
			
		public PersonBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
			
		public PersonBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public PersonBuilder setIsMale(boolean isMale) {
			this.isMale = isMale;
			return this;
		}
		
		public Person build() {
			return new Person(this.firstName, this.lastName, this.age, this.isMale);
		}
		
	}
	
	@Override
	public String toString() {
		return "First name: " + this.firstName + ", last name: " + this.lastName
				+ ", age: " + this.age + ", isMale: " + isMale;
	}
	
} //end class Person





