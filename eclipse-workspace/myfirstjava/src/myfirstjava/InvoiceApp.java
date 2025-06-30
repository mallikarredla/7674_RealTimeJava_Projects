//E12731407-Durga prasad


package myfirstjava;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;
public class InvoiceApp {
	
	public static void main(String[] args) {
		
		final double SALES_TAX_PCT = 0.05;
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
        	
            System.out.print("Enter subtotal: ");
            
            double subtotal = sc.nextDouble();
            
            double discountPercent = 0.0;

            if (subtotal >= 100) {
            	
                discountPercent = 0.1;
            } else {
                discountPercent = 0.0;
            }

            // calculate the results
            double discountAmount = subtotal * discountPercent;
            
            double totalBeforeTax = subtotal - discountAmount;
            
            double salesTax = totalBeforeTax * SALES_TAX_PCT;
            
            double total = totalBeforeTax + salesTax;
            // format and display the results
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            
            NumberFormat percent = NumberFormat.getPercentInstance();

            String message = "Discount percent: " + percent.format(discountPercent) + "\n"
                           + "Discount amount: " + currency.format(discountAmount) + "\n"
                           + "Total before tax: " + currency.format(totalBeforeTax) + "\n"
                           + "Sales tax: " + currency.format(salesTax) + "\n"
                           + "Invoice total: " + currency.format(total);
            
            System.out.println(message);
            
            System.out.print("Would you like to enter another subtotal? (y/n): ");
            choice = sc.next();
        }
        
        sc.close();

            
            
           
}

}
