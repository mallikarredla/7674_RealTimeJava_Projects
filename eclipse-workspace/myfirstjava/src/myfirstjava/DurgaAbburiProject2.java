
//DurgaPrasadAbburi[E12731407]
package myfirstjava;

import java.util.Scanner;

public class DurgaAbburiProject2 {
	 private static final double TAX_RATE = 0.0475;

	public static void main(String[] args) {
		 

		    
		        Scanner scanner = new Scanner(System.in);

		        String storeName = "WelcometoSimplifiedComputer";
		        String[] splitStoreName = storeName.split("(?=[A-Z])");
		        for (String word : splitStoreName) {
		            System.out.println(word);
		        }
		        
		        

		        // Replacing Thursday with Friday
		        String openingDays = "We are open Monday to Thursday from 9 am to 6 pm";
		        openingDays = openingDays.replace("Thursday", "Friday");
		        System.out.println(openingDays);

		        // Asking user for a visiting day
		        System.out.println("What day are you visting the Store?");
		        String visitDay = scanner.next().toLowerCase();
		        switch (visitDay) {
	            case "monday":
	            case "tuesday":
	            case "wednesday":
	            case "thursday":
	            case "friday":
	                System.out.println("You are welcomed to the Store");
	                break;
	            case "saturday":
	            case "sunday":
	                System.out.println("Sorry, the store is closed on " + visitDay + ".");
	                return;
	            default:
	                System.out.println("Invalid day entered.");
	                return;
		        }
		        
		        System.out.println();
		        System.out.println();
		     // Displaying products and taking user input
		        System.out.println("Available Laptops:");
		        System.out.println("Lenovo = $1950.89");
		        System.out.println("Dell = $910.54");
		        System.out.println("HP = $1345.95");
		        System.out.println("Asus = $506.00");
		        System.out.println();
		        System.out.println();
		        
		        
		        
		     // Displaying external drives
		        System.out.println("Available External Drives:");
		        System.out.println("Startech = $50.55");
		        System.out.println("Seagate = $75.00");
		        System.out.println("Sandisk = $119.99");
		        System.out.println("Wd = $129.99");
		        System.out.println();
		        System.out.println();
		        
		        
		        double maxLaptopPrice = Math.max(Math.max(1950.89, 910.54), Math.max(1345.95, 506.00));
		        double minLaptopPrice = Math.min(Math.min(1950.89, 910.54), Math.min(1345.95, 506.00));
		        double maxDrivePrice = Math.max(Math.max(50.55, 75.00), Math.max(119.99, 129.99));
		        double minDrivePrice = Math.min(Math.min(50.55, 75.00), Math.min(119.99, 129.99));
		        System.out.println();
		        System.out.println();
		        System.out.println("Most expensive laptop: $" + maxLaptopPrice);
		        System.out.println("Least expensive laptop: $" + minLaptopPrice);
		        System.out.println("Most expensive external drive: $" + maxDrivePrice);
		        System.out.println("Least expensive external drive: $" + minDrivePrice);
		        System.out.println();
		        System.out.println();
		        System.out.println("what laptop brand would you like(Lenovo/Dell/Hp/Asus)? ");
		        String laptopChoice = scanner.next().toString();
		        double laptopPrice =0;
		        switch (laptopChoice) {
		        case "Lenovo": 
		        	String lenovoprice = "1950.89";
		        	laptopPrice = Double.parseDouble(lenovoprice);
		        	System.out.println("You chose Lenovo, which costs $" + laptopPrice);
		        	break;
		        
	            case "Dell": 
	            	String dellprice = "910.54";
		        	laptopPrice = Double.parseDouble(dellprice);
		        	System.out.println("You chose Dell, which costs $" + laptopPrice);
		        	break;
	            case "Hp": 
	            	String hpprice = "1345.95";
		        	laptopPrice = Double.parseDouble(hpprice);
		        	System.out.println("You chose Hp, which costs $" + laptopPrice);
		        	break;
		        	
	            case "Asus": 
	            	String asusprice = "506.00";
		        	laptopPrice = Double.parseDouble(asusprice);
		        	System.out.println("You chose Asus, which costs $" + laptopPrice);
		        	break;
		        	
	            default:
	                System.out.println("Invalid laptop brand.");
	                return;
	        
		        }
		        System.out.println();
		        System.out.println();
		        System.out.println("would you like to get an External Drive(yes/no)?");
		        String choice = scanner.next().toString();
		        switch(choice) {
		        case "yes":
		        	System.out.println("what External Drive brand would you like(Startech/Seagate/Sandisk/Wd)?");
			        String driveChoice = scanner.next().toString();
			        double drivePrice = 0;
			        switch (driveChoice) {
			            case "Startech": 
			            	String StartechPrice = "50.55"; 
			            	drivePrice = Double.parseDouble(StartechPrice);
			            	System.out.println("You chose Startech, which costs $" +drivePrice);
			            	break;
			            case "Seagate":
			            	String SeagatePrice = "75.00"; 
			            	drivePrice = Double.parseDouble(SeagatePrice);
			            	System.out.println("You chose Seagate, which costs $" +drivePrice);
			            	break;
			            	
			            case "Sandisk":
			            	String SandiskPrice = "119.99"; 
			            	drivePrice = Double.parseDouble(SandiskPrice);
			            	System.out.println("You chose Sandisk, which costs $" +drivePrice);
			            	break;
			            	
			            case "Wd": 
			            	String WdPrice = "129.99"; 
			            	drivePrice = Double.parseDouble(WdPrice);
			            	System.out.println("You chose Wd, which costs $" +drivePrice);
			            	break;
			            default:
			                System.out.println("Invalid External Drive brand");
			                return;
			        }
		        
			        System.out.println();
			        System.out.println();
			        double totalCost = laptopPrice + drivePrice;
			        //System.out.println("The total price is: $" +totalCost);
			        double discount = 0;

			        if (totalCost >= 1750) {
			            discount = 0.15;
			        } else if (totalCost > 1500) {
			            discount = 0.10;
			        } else if (totalCost > 1000) {
			            discount = 0.05;
			        }
		        
			        double discountAmount = totalCost * discount;
			        double discountedTotal = totalCost - discountAmount;
			        double taxAmount = discountedTotal * TAX_RATE;
			        double finalPrice = discountedTotal + taxAmount;

			        //System.out.println("Total before discount: $" + totalCost);
			        //System.out.println("Discount applied: $" + discountAmount);
			        //System.out.println("Tax (4.75%): $" + taxAmount);
			        System.out.println("The total price is :$"+finalPrice);
			        break;
		        default:
		        	System.out.println("please get one next time:");
		        	System.out.println();
			        System.out.println();
			        double tc = laptopPrice;
			        discount = 0;
			        if (tc >= 1750) {
			            discount = 0.15;
			        } else if (tc > 1500) {
			            discount = 0.10;
			        } else if (tc > 1000) {
			            discount = 0.05;
			        }
			        double da = tc * discount;
			        double dt = tc - da;
			        double ta = dt * TAX_RATE;
			        double fp = dt + ta;
			        System.out.println("The total price is :$"+fp);
			      
		        	return;
		        }
		        
		       
		        
	
			        
			        
		        
		        
		        
		        
		        
		        
		     
		        
		        
		        
		        
		        
		        
		        
		     
		     
		        
		        
		        
		        


	}

}
