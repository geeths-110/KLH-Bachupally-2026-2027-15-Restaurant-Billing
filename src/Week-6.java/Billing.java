 import java.util.*;
public class Billing {

    static double calculateSubtotal(double price, int quantity) {
        return price * quantity;
    }

    static double calculateDiscount(double subtotal) {
        if (subtotal >= 1000) {
            return subtotal * 0.10;
        } else if (subtotal >= 500) {
            return subtotal * 0.05;
        } else {
            return 0;
        }
    }

    static double calculateTax(double amount) {
        return amount * 0.05;
    }

    static void displayKitchenStatus(int status) {
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
    }

    static int countItems(int quantity) {
        if (quantity == 0) {
            return 0;
        }
        return 1 + countItems(quantity - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] menuItems = {"Biryani", "Pizza", "Burger"};
        double[] prices = {200, 250, 120};

        int[][] menuDetails = {
            {1, 200},
            {2, 250},
            {3, 120}
        };

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        double subtotal = 0;
        int itemCount = 0;
        int choice;

        do {
            System.out.println("\n--- Restaurant Menu ---");

            for (int i = 0; i < menuItems.length; i++) {
                System.out.println((i + 1) + ". " + menuItems[i] + " - ₹" + prices[i]);
            }

            System.out.println("4. Finish Order");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 4) {
                break;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice.");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                System.out.println("Invalid quantity.");
                continue;
            }

            int index = choice - 1;
            double price = prices[index];

            subtotal += calculateSubtotal(price, quantity);
            itemCount += countItems(quantity);

        } while (true);

        double discount = calculateDiscount(subtotal);
        double tax = calculateTax(subtotal - discount);
        double total = subtotal - discount + tax;

        System.out.print("Enter Kitchen Status (1-3): ");
        int status = sc.nextInt();

        System.out.println("\n--- Order Details ---");
        System.out.println("Customer: " + name);
        System.out.println("Total Items: " + itemCount);

        System.out.println("\n--- Kitchen ---");
        displayKitchenStatus(status);

        System.out.println("\n--- Bill ---");
        System.out.printf("Subtotal: ₹%.2f%n", subtotal);
        System.out.printf("Discount: ₹%.2f%n", discount);
        System.out.printf("Tax (5%%): ₹%.2f%n", tax);
        System.out.printf("Total Bill: ₹%.2f%n", total);

        sc.close();
    }
}

