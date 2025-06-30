package Inheritance;
class Animal{
	
	 public void eat() {
		System.out.println("animal is eating");
		
	}
	
	 public void Drink() {
		System.out.println("animal is drinking");
		
	}
	public class Dog extends Animal{
		
	public void Bark() {
		System.out.println("dog is barking");
		
		
	}
	public void sneez() {
		 Drink();
		 eat();
		
		
	}
		

}
	
}
public class SimpleInheritance {
	public static void main(String[] args) {
		Animal A1= new Animal();
		A1.Drink();
		A1.eat();
		
		
		
	}

}
