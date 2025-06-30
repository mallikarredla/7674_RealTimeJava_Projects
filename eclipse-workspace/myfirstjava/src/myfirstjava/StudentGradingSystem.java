package myfirstjava;

import java.util.Scanner;

public class StudentGradingSystem {
	

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String continueProgram;

	        do {
	            // User Information
	            System.out.print("Enter your full name: ");
	            String name = scanner.nextLine();
	            System.out.print("Enter your E-Number: ");
	            String eNumber = scanner.nextLine();

	            // Input for different grading sections
	            System.out.print("Enter Class Participation score (max 10%): ");
	            double participation = scanner.nextDouble();
	            if (participation > 10) participation = 10;
	            
	            System.out.print("Enter Assignments score (max 25%): ");
	            double assignments = scanner.nextDouble();
	            if (assignments > 25) assignments = 25;
	            
	            System.out.print("Enter Projects score (max 50%): ");
	            double projects = scanner.nextDouble();
	            if (projects > 50) projects = 50;
	            
	            System.out.print("Enter Tests score (max 15%): ");
	            double tests = scanner.nextDouble();
	            if (tests > 15) tests = 15;

	            // Calculate total percentage
	            double totalGrade = participation + assignments + projects + tests;
	            System.out.println("Total Grade Percentage: " + totalGrade + "%");

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
	            
	            // Loop for continuation
	            scanner.nextLine(); // Consume newline character
	            do {
	                System.out.print("Do you wish to continue? (yes/no): ");
	                continueProgram = scanner.nextLine().trim().toLowerCase();
	            } while (!continueProgram.equals("no") && !continueProgram.equals("yes"));

	        } while (!continueProgram.equals("no"));

	        System.out.println("Program terminated.");
	        scanner.close();
	    }
	}



