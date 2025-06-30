

//DurgaPrasad Abburi[E12731407]
package myfirstjava;

import java.util.Scanner;

public class FirstLastNameProject1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice ="y/n";
		while(choice.equalsIgnoreCase(choice)){
		
		
		System.out.println("Enter your Name:");
		String Name = sc.nextLine();
		System.out.println("Enter your E-Number:");
		String ENumber = sc.nextLine();
		int [] numbers = {4,7,10,6,6,6,0,2,9,2};
		int sum = 0;
		for(int number :numbers) {
			sum +=number;
		}
		System.out.println(sum);
		//The sum of the above data which is 52.Class Participation is 30% of my grade.
		System.out.println("Enter the class Participation of your grade:");
		double Cpgrade = sc.nextDouble();
		Double grade = Cpgrade * sum;
		
		//The sum of the above data which is 52.Assignment Participation is 40% of my grade.
		System.out.println("Enter the Assignment Participation of your grade:");
		Double assignments = sc.nextDouble();
		Double assign = assignments *sum ;
		
		//The sum of the above data which is 52.Test Participation is 15% of my grade.
		System.out.println("Enter the Tests Participation of your grade:");
		Double tests = sc.nextDouble();
		Double test = tests *sum ;
		
		//The sum of the above data which is 52.Project Participation is 15% of my grade.
		System.out.println("Enter the projects Participation of your grade:");
		Double projects = sc.nextDouble();
		Double project = projects *sum ;
		
		
		System.out.println("Displaying the total grade percentage:");
		Double totalGrade = grade+assign+test+project;
		System.out.println(totalGrade);
		
		// Determine final letter grade
        if (totalGrade >= 90) {
            System.out.println("Final Grade: A");
        } else if (totalGrade >= 80) {
            System.out.println("Final Grade: B");
        } else if (totalGrade >= 70) {
            System.out.println("Final Grade: C");
        } else if (totalGrade >= 60) {
            System.out.println("Final Grade: D");
        } else {
            System.out.println("You have failed the class.");
        }
        
        
     System.out.print("Do you wish to continue? (yes/no): ");
     choice = sc.next();
            
    System.out.println();
    
	}
        
		
		
		
		
		
		
		 
	}
	
	
	

	

}
