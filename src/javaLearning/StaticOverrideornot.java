package javaLearning;

class Parent {
    static void display() {
        System.out.println("Static method in Parent class");
    }
}

class Child extends Parent {
    static void display() {
        System.out.println("Static method in Child class");
    }
}

//  Multiple markers at this line
//- This static method cannot hide the instance method from Parent
//- This instance method cannot override the static method from Parent

public class StaticOverrideornot {
    public static void main(String[] args) {
        Parent.display(); // Output: Static method in Parent class
        Child.display();  // Output: Static method in Child class

        Parent obj = new Child();
        obj.display();    // Output: Static method in Parent class
        
    }
}
