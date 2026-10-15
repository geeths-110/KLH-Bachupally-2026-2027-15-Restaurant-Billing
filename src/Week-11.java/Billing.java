import java.io.*;
import java.nio.file.*;
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
                + String.format("%.2f", calculateSubtotal());
    }
}

class Order {
    private String customerName;
    private ArrayList<FoodItem> items = new ArrayList<>();

    public Order(String customerName) {
        this.customerName = customerName.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<FoodItem> getItems() {
        return items;
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
        System.out.println("Customer: "
                + customerName.toUpperCase());

        items.sort(Comparator.comparingDouble(
                FoodItem::getPrice));

        for (FoodItem item : items) {
            System.out.println(item);
        }

        System.out.println("Total Items: " + countItems());
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

    static void saveReport(Order order, double subtotal,
            double discount, double tax, double total, int status) {
        Path path = Path.of("OrderReport.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("RESTAURANT ORDER REPORT");
            writer.newLine();
            writer.write("Customer: " + order.getCustomerName());
            writer.newLine();

            for (FoodItem item : order.getItems()) {
                writer.write(item.toString());
                writer.newLine();
            }

            writer.write("Total Items: " + order.countItems());
            writer.newLine();
            writer.write(String.format("Subtotal: Rs. %.2f", subtotal));
            writer.newLine();
            writer.write(String.format("Discount: Rs. %.2f", discount));
            writer.newLine();
            writer.write(String.format("Tax (5%%): Rs. %.2f", tax));
            writer.newLine();
            writer.write(String.format("Total Bill: Rs. %.2f", total));
            writer.newLine();

            String[] statuses = {
                "Invalid Kitchen Status",
                "Pending",
                "Preparing",
                "Ready"
            };

            String kitchenStatus = status >= 1 && status <= 3
                    ? statuses[status] : statuses[0];

            writer.write("Kitchen Status: " + kitchenStatus);
            writer.newLine();

            System.out.println("Report saved to OrderReport.txt");

        } catch (IOException e) {
            System.out.println("Error saving report: "
                    + e.getMessage());
        }
    }

    static void readReport() {
        Path path = Path.of("OrderReport.txt");

        System.out.println("\n--- Saved Report ---");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading report: "
                    + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Biryani", "Pizza", "Burger"};
        double[] prices = {200, 250, 120};

        ArrayList<FoodItem> menu = new ArrayList<>();
        HashMap<String, Double> priceMap = new HashMap<>();
        TreeMap<String, Double> sortedPrices = new TreeMap<>();
        TreeSet<String> uniqueNames = new TreeSet<>();

        try {
            for (int i = 0; i < names.length; i++) {
                menu.add(new FoodItem(names[i], prices[i], 1));
                priceMap.put(names[i], prices[i]);
                sortedPrices.put(names[i], prices[i]);
                uniqueNames.add(names[i]);
            }
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
            sc.close();
            return;
        }

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
        Queue<String> kitchenQueue = new LinkedList<>();
        Deque<String> recentItems = new ArrayDeque<>();

        int choice;

        do {
            System.out.println("\n--- Restaurant Menu ---");

            for (int i = 0; i < menu.size(); i++) {
                FoodItem item = menu.get(i);
                System.out.println((i + 1) + ". "
                        + item.getName() + " - Rs. "
                        + item.getPrice());
            }

            System.out.println("4. Finish Order");
            System.out.println("5. Show Sorted Price List");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 4) {
                break;
            }

            if (choice == 5) {
                System.out.println("\n--- Sorted Price List ---");

                for (Map.Entry<String, Double> entry
                        : sortedPrices.entrySet()) {
                    System.out.println(entry.getKey() + " - Rs. "
                            + entry.getValue());
                }

                continue;
            }

            if (choice < 1 || choice > menu.size()) {
                System.out.println("Invalid choice.");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            try {
                FoodItem selected = menu.get(choice - 1);

                FoodItem item = new FoodItem(
                        selected.getName(),
                        priceMap.get(selected.getName()),
                        quantity);

                order.addItem(item);
                kitchenQueue.offer(item.getName());
                recentItems.push(item.getName());

                System.out.println("Item added successfully.");

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

        System.out.println("\n--- Kitchen Queue ---");
        if (kitchenQueue.isEmpty()) {
            System.out.println("No items in queue.");
        } else {
            System.out.println(kitchenQueue);
        }

        System.out.println("\n--- Unique Menu Items ---");
        System.out.println(uniqueNames);

        System.out.println("\n--- Recently Added Item ---");
        System.out.println(recentItems.peek());

        System.out.println("\n--- Bill ---");
        System.out.printf("Subtotal: Rs. %.2f%n", subtotal);
        System.out.printf("Discount: Rs. %.2f%n", discount);
        System.out.printf("Tax (5%%): Rs. %.2f%n", tax);
        System.out.printf("Total Bill: Rs. %.2f%n", total);

        saveReport(order, subtotal, discount, tax, total, status);
        readReport();

        sc.close();
    }
}
