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

        if (quantity <= 0 || price <= 0) {
            System.out.println("Invalid order details.");
            sc.close();
            return;
        }

        double subtotal = quantity * price;
        double discount;

        if (subtotal >= 1000) {
            discount = subtotal * 0.10;
        } else if (subtotal >= 500) {
            discount = subtotal * 0.05;
        } else {
            discount = 0;
        }

        double tax = (subtotal - discount) * 0.05;
        double total = subtotal - discount + tax;

        System.out.print("Enter Kitchen Status (1-3): ");
        int status = sc.nextInt();

        System.out.println("\n--- Order Details ---");
        System.out.println("Customer: " + name);
        System.out.println("Food Item: " + item);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Price per Item: %s%.2f%n", CURRENCY, price);

        System.out.println("\n--- Kitchen ---");

        switch (status) {
            case 1:
                System.out.println("Order Status: Pending");
                break;
            case 2:
                System.out.println("Order Status: Preparing");
                break;
            case 3:
                System.out.println("Order Status: Ready");
                break;
            default:
                System.out.println("Invalid Kitchen Status");
        }

        System.out.println("\n--- Bill ---");
        System.out.printf("Subtotal: %s%.2f%n", CURRENCY, subtotal);
        System.out.printf("Discount: %s%.2f%n", CURRENCY, discount);
        System.out.printf("Tax (5%%): %s%.2f%n", CURRENCY, tax);
        System.out.printf("Total Bill: %s%.2f%n", CURRENCY, total);

        sc.close();
    }
    
}
