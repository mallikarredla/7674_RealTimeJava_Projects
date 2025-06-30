package Inheritance;

public class Dog {
	String name;
	void bark() {
		System.out.println(name+ "says woof");
		}

	
	public static void main(String[] args) {
		Dog myDog=new Dog();
		myDog.name="kroger";
		myDog.bark();
		System.out.println(myDog);
		
		
		
	}
}
