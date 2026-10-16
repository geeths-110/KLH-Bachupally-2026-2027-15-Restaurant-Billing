 import java.util.*;
public class Billing {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String CURRENCY = "₹";

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Food Item: ");
        String item = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price per Item: ");
        double price = sc.nextDouble();

        double subtotal = quantity * price;
        double tax = subtotal * 0.05;
        double total = subtotal + tax;

        System.out.println("\n--- Order Details ---");
        System.out.println("Customer: " + name);
        System.out.println("Food Item: " + item);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Price per Item: %s%.2f%n", CURRENCY, price);

        System.out.println("\n--- Kitchen ---");
        System.out.println("Order Status: Pending");

        System.out.println("\n--- Bill ---");
        System.out.printf("Subtotal: %s%.2f%n", CURRENCY, subtotal);
        System.out.printf("Tax (5%%): %s%.2f%n", CURRENCY, tax);
        System.out.printf("Total Bill: %s%.2f%n", CURRENCY, total);

        sc.close();
    }
}


