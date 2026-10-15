import java.util.*;
public class Billing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String CURRENCY = "₹";

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        double subtotal = 0;
        int itemCount = 0;
        int choice;

        do {
            System.out.println("\n--- Restaurant Menu ---");
            System.out.println("1. Biryani - ₹200");
            System.out.println("2. Pizza - ₹250");
            System.out.println("3. Burger - ₹120");
            System.out.println("4. Finish Order");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 4) {
                break;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice.");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                System.out.println("Invalid quantity.");
                continue;
            }

            double price;

            switch (choice) {
                case 1:
                    price = 200;
                    break;
                case 2:
                    price = 250;
                    break;
                case 3:
                    price = 120;
                    break;
                default:
                    price = 0;
            }

            subtotal += price * quantity;
            itemCount += quantity;

        } while (true);

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
        System.out.println("Total Items: " + itemCount);

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


    