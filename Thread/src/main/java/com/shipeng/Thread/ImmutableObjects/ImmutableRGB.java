package com.shipeng.Thread.ImmutableObjects;

/**
 * @author sxu
 * 
 * 
 * Immutable Objects
 * an object is considered immutable if its state cannot change after it is constructed.
 * Maximum reliance on immutable objects is widely accepted as a sound strategy for creating simple, reliable code.
 * 
 * Immutable objects are particularly useful in concurrent applications. Since they cannot change state, tehy cannot be corrupted by thread interference
 * or observed in an inconsistent state.
 * 
 * Programmers are often reluctant to employ immutable objects, because they worry about the  cost of creating a new object as opposed to updating an object in place.
 * The impact of object creation is often overestimated, and can be offset by some of the efficiencies associated with immutable objects. these include decreased overhead
 * due to garbage collection, and the elimination of code needed to protect mutable objects from corruption.
 * 
 * 
 * A strategy fo defining immutable objects
 * The following rules define a simple strategy for creating immutable objects.
 * Not all classes documented as "immutable" follow these rules. 
 * This does not necessarily mean the creators of these classes were sloppy 
 * they may have good reasons for believing that instances of their classes never change after construction.
 * However, such strategies require sophisticated analysis and are not for beginners.
 * 
 * 	1. Don't provide "setter" methods --- methods that modify fields or objects referred to by fields.
 *  2. Make all fields final and private
 *  3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
 *     A more sophisticated approach is to make the constructor private and construct instances in factory methods.
 *  4. if the instance fields include references to mutable objects, don't allow those objects to be changed:
 *        don't provide methods that modify the mutable objects.
 *        don't share references to the mutable objects. never store references to external, mutable objects passed to the constructor.
 *        if necessary, create copies, and store references to the copies.
 *        Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
 *        
 * 
 * 
 */

final public class ImmutableRGB {
	
	// Values must be between 0 and 255.
	final private int red;
	final private int green;
	final private int blue;
	final private String name;
	
	private void check(int red, int green, int blue) {
		if (red < 0 || red > 255 || green < 0 || green > 255 || blue <0 || blue > 255) {
			throw new IllegalArgumentException();
		}
	}
	
	public ImmutableRGB(int red, int green, int blue, String name) {
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}
	
	public int getRGB() {
		return ((red << 16 ) | (green << 8) | blue);
	}
	
	public String getName() {
		return name;
	}
	
	public ImmutableRGB invert() {
		return new ImmutableRGB(255 - red, 255 - green, 255 - blue, "Inverse of " + name);
	}
	
}
