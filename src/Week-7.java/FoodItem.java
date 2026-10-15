
import java.util.*;
class FoodItem {
    private String name;
    private double price;
    private int quantity;

    public FoodItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateSubtotal() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return name + " x " + quantity + " = Rs. "
                + calculateSubtotal();
    }
}

class Order {
    private String customerName;
    private ArrayList<FoodItem> items;
    private static int orderCount = 0;

    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
        orderCount++;
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (FoodItem item : items) {
            subtotal += item.calculateSubtotal();
        }
        return subtotal;
    }

    public int countItems() {
        int count = 0;
        for (FoodItem item : items) {
            count += item.getQuantity();
        }
        return count;
    }

    public void displayOrder() {
        System.out.println("Customer: " + customerName);
        for (FoodItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total Items: " + countItems());
    }

    public static int getOrderCount() {
        return orderCount;
    }
}

public class Billing {

    static double calculateDiscount(double subtotal) {
        if (subtotal >= 1000) {
            return subtotal * 0.10;
        } else if (subtotal >= 500) {
            return subtotal * 0.05;
        }
        return 0;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] menuItems = {"Biryani", "Pizza", "Burger"};
        double[] prices = {200, 250, 120};

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        Order order = new Order(name);
        int choice;

        do {
            System.out.println("\n--- Restaurant Menu ---");

            for (int i = 0; i < menuItems.length; i++) {
                System.out.println((i + 1) + ". "
                        + menuItems[i] + " - Rs. " + prices[i]);
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

            FoodItem item = new FoodItem(
                    menuItems[index], prices[index], quantity);

            order.addItem(item);

        } while (true);

        double subtotal = order.calculateSubtotal();
        double discount = calculateDiscount(subtotal);
        double tax = calculateTax(subtotal - discount);
        double total = subtotal - discount + tax;

        System.out.print("Enter Kitchen Status (1-3): ");
        int status = sc.nextInt();

        System.out.println("\n--- Order Details ---");
        order.displayOrder();

        System.out.println("\n--- Kitchen ---");
        displayKitchenStatus(status);

        System.out.println("\n--- Bill ---");
        System.out.printf("Subtotal: Rs. %.2f%n", subtotal);
        System.out.printf("Discount: Rs. %.2f%n", discount);
        System.out.printf("Tax (5%%): Rs. %.2f%n", tax);
        System.out.printf("Total Bill: Rs. %.2f%n", total);

        System.out.println("Total Orders Created: "
                + Order.getOrderCount());

        sc.close();
    }
}
