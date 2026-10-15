import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

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
        return items.stream()
                .mapToDouble(FoodItem::calculateSubtotal)
                .sum();
    }

    public int countItems() {
        return items.stream()
                .mapToInt(FoodItem::getQuantity)
                .sum();
    }

    public void displayOrder() {
        System.out.println("Customer: "
                + customerName.toUpperCase());

        items.stream()
                .sorted(Comparator.comparingDouble(
                        FoodItem::getPrice))
                .forEach(System.out::println);

        System.out.println("Total Items: " + countItems());
    }

    public void displayStreamReports() {
        System.out.println("\n--- Stream Reports ---");

        List<String> foodNames = items.stream()
                .map(FoodItem::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Unique Ordered Items: " + foodNames);

        Map<String, Integer> quantities = items.stream()
                .collect(Collectors.groupingBy(
                        FoodItem::getName,
                        TreeMap::new,
                        Collectors.summingInt(
                                FoodItem::getQuantity)));

        System.out.println("Quantity by Food: " + quantities);

        Map<Boolean, List<FoodItem>> priceGroups = items.stream()
                .collect(Collectors.partitioningBy(
                        item -> item.getPrice() >= 200));

        System.out.println("Items priced Rs. 200 or more: "
                + priceGroups.get(true).size());

        int totalQuantity = items.stream()
                .mapToInt(FoodItem::getQuantity)
                .sum();

        double averagePrice = items.stream()
                .mapToDouble(FoodItem::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("Total Quantity: " + totalQuantity);
        System.out.printf("Average Unit Price: Rs. %.2f%n",
                averagePrice);

        Optional<FoodItem> highestPriced = items.stream()
                .max(Comparator.comparingDouble(
                        FoodItem::getPrice));

        highestPriced.ifPresent(item ->
                System.out.println("Highest-Priced Item: "
                        + item.getName() + " - Rs. "
                        + item.getPrice()));

        String itemSummary = items.stream()
                .map(FoodItem::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println("Item Summary: " + itemSummary);
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
                "Pending", "Preparing", "Ready"
            };

            String kitchenStatus = status >= 1 && status <= 3
                    ? statuses[status] : statuses[0];

            writer.write("Kitchen Status: " + kitchenStatus);
            writer.newLine();

            writer.write("Unique Ordered Items: "
                    + order.getItems().stream()
                    .map(FoodItem::getName)
                    .distinct()
                    .sorted()
                    .collect(Collectors.joining(", ")));
            writer.newLine();

            Map<String, Integer> quantities = order.getItems().stream()
                    .collect(Collectors.groupingBy(
                            FoodItem::getName,
                            TreeMap::new,
                            Collectors.summingInt(
                                    FoodItem::getQuantity)));

            writer.write("Quantity by Food: " + quantities);
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

        try {
            for (int i = 0; i < names.length; i++) {
                menu.add(new FoodItem(names[i], prices[i], 1));
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
                menu.stream()
                        .sorted(Comparator.comparingDouble(
                                FoodItem::getPrice))
                        .forEach(item ->
                                System.out.println(item.getName()
                                        + " - Rs. "
                                        + item.getPrice()));
                continue;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice.");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            try {
                FoodItem selected = menu.get(choice - 1);
                FoodItem item = new FoodItem(
                        selected.getName(),
                        selected.getPrice(),
                        quantity);

                order.addItem(item);
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

        order.displayStreamReports();

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
