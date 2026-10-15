import java.util.*;
public class Billing {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Food Item: ");
        String item = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price per Item: ");
        double price = sc.nextDouble();

        double total = quantity * price;

        System.out.println("\n--- Order Details ---");
        System.out.println("Customer: " + name);
        System.out.println("Food Item: " + item);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per Item: ₹" + price);

        System.out.println("\n--- Kitchen ---");
        System.out.println("Order Status: Pending");
        System.out.println("Order Status: Preparing");
        System.out.println("Order Status: Ready");

        System.out.println("\n--- Bill ---");
        System.out.println("Customer: " + name);
        System.out.println("Item: " + item);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Bill: ₹" + total);

        sc.close();
    }
    
}
