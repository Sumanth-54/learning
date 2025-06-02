package javaLearning;

// Java program to demonstrate
// an abstract class

// Abstract parent class
abstract class Book {

	// Abstract method without body
	public abstract void page();
}

// shayar class extends Book class
public class Sample extends Book {

	// Declaring the abstract method
	public void page() {
		System.out.println("Geek");
	}

	// Driver code
	public static void main(String args[]) {
		Book obj = new Sample();
		obj.page();
	}
}
