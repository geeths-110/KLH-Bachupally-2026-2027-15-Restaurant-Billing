import java.util.*;
interface DiscountStrategy {
    double calculateDiscount(double subtotal);
}
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
class FoodItem implements Comparable<FoodItem> {
    private String name;
    private double price;
    private int quantity;
    public FoodItem(String name, double price, int quantity)
            throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than zero.");
        }
        this.name = name.trim();
        this.price = price;
        this.quantity = quantity;
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
    public double calculateSubtotal() {
        return price * quantity;
    }
    @Override
    public int compareTo(FoodItem other) {
        return name.compareToIgnoreCase(other.name);
    }
    @Override
    public String toString() {
        return name + " x " + quantity + " = Rs. "
                + calculateSubtotal();
    }
}
class Order {
    private String customerName;
    private ArrayList<FoodItem> items;
    public Order(String customerName) {
        this.customerName = customerName.trim();
        items = new ArrayList<>();
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
        StringBuilder receipt = new StringBuilder();
        receipt.append("Customer: ")
                .append(customerName.toUpperCase())
                .append("\n");
        items.sort(Comparator.comparingDouble(
                FoodItem::getPrice));
        for (FoodItem item : items) {
            receipt.append(item).append("\n");
        }
        receipt.append("Total Items: ").append(countItems());
        System.out.println(receipt);
    }
}
public class Billing {
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
        FoodItem[] menu = new FoodItem[3];
        try {
            menu[0] = new FoodItem("Biryani", 200, 1);
            menu[1] = new FoodItem("Pizza", 250, 1);
            menu[2] = new FoodItem("Burger", 120, 1);
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
            sc.close();
            return;
        }
        Arrays.sort(menu);
        DiscountStrategy discountStrategy = subtotal -> {
            if (subtotal >= 1000) {
                return subtotal * 0.10;
            } else if (subtotal >= 500) {
                return subtotal * 0.05;
            }
            return 0;
        };
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            sc.close();
            return;
        }
        Order order = new Order(name);
        int choice;
        do {
            System.out.println("\n--- Restaurant Menu ---");
             for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". "
                        + menu[i].getName() + " - Rs. "
                        + menu[i].getPrice());
            }
            System.out.println("4. Finish Order");
            System.out.println("5. Search Menu Item");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 4) {
                break;
            }
            if (choice == 5) {
                System.out.print("Enter food name to search: ");
                String searchName = sc.nextLine().trim();
                FoodItem key = null;
                try {
                    key = new FoodItem(searchName, 0, 1);
                } catch (InvalidQuantityException e) {
                    System.out.println(e.getMessage());
                }
                int position = Arrays.binarySearch(menu, key);
                if (position >= 0) {
                    System.out.println("Item Found: "
                            + menu[position].getName()
                            + " - Rs. "
                            + menu[position].getPrice());
                } else {
                    System.out.println("Item not found.");
                }
                continue;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice.");
                continue;
            }
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            try {
                int index = choice - 1;
                FoodItem item = new FoodItem(
                        menu[index].getName(),
                        menu[index].getPrice(),
                        quantity);
                order.addItem(item);
            } catch (InvalidQuantityException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Quantity check completed.");
            }
        } while (true);
        double subtotal = order.calculateSubtotal();
        double discount = discountStrategy.calculateDiscount(subtotal);
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
        sc.close();
    }
}
