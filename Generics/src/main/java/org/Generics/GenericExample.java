package org.Generics;

/*
 * Write a simple generic class example
 * Below example shows how to create a simple generics class.
 * We have created SimpleGeneric class, which accepts single type parameter.
 * Look at the generics class definition, the type parameter should be followed by class name
 * and should contain with in <>, here T defines the type parameter. 
 * You can find comments at example itself.
 */

public class GenericExample {

	public static void main(String a[]) {

		/**
		 * Here T is a type parameter, and it will be replaced with actual type
		 * when the object got created.
		 */
		class SimpleGeneric<T> {

			// declaration of object type T
			private T objReff = null;

			// constructor to accept type parameter T
			public SimpleGeneric(T param) {
				this.objReff = param;
			}

			public T getObjReff() {
				return this.objReff;
			}

			// this method prints the holding parameter type
			public void printType() {
				System.out.println("Type: " + objReff.getClass().getName());
			}
		}

		// we are going to create SimpleGeneric object with String as type
		// parameter
		SimpleGeneric<String> sgs = new SimpleGeneric<String>("JAVA2NOVICE");
		sgs.printType();
		// we are going to create SimpleGeneric object with Boolean as type
		// parameter
		SimpleGeneric<Boolean> sgb = new SimpleGeneric<Boolean>(Boolean.TRUE);
		sgb.printType();
	}

}
