//Durgaprasad Abburi E12731407

package myfirstjava;

import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the day?");
		String day = sc.next();
		if(day.equalsIgnoreCase("Monday")||day.equalsIgnoreCase("Tuesday")||
				day.equalsIgnoreCase("Wednesday")||day.equalsIgnoreCase("Thrusday")||
				day.equalsIgnoreCase("Friday")){
		System.out.println("Weekday");
		}
				
		
		else if
		(day.equalsIgnoreCase("Saturday")||day.equalsIgnoreCase("Sunday")) {
			System.out.println("Weekend");
			
		}
		else {
			System.out.println("Invalid Day");
		}
		

	}
	

}
