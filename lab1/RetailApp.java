import java.util.Scanner;
import java.util.ArrayList;

public class RetailApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> sku = new ArrayList<Integer>();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> prices = new ArrayList<Double>();
        ArrayList<Integer> quantities = new ArrayList<Integer>();

        System.out.print("Enter store name: ");
        String storeName = scanner.nextLine();

        System.out.print("Enter starting budget (>= 0): ");
        double budget = scanner.nextDouble();

        scanner.nextLine();

        System.out.printf("Welcome to " + storeName + "! Current budget: $%.2f", budget);

        boolean running = true;
        while (running) {
            System.out.println("\n====== Retail Management System ======");
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("--- Add Item ---");

                    System.out.print("Enter SKU: ");
                    sku.add(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Enter item name: ");
                    names.add(scanner.nextLine());

                    double price = 0;
                    while (price <= 0 ) {
                        System.out.print("Enter price (> 0): ");
                        price = scanner.nextDouble();
                        if (price <= 0) System.out.println("Price must be positive.");
                    }
                    prices.add(price);

                    int quantity = 0;
                    while (quantity <= 0) {
                        System.out.print("Enter quantity (> 0): ");
                        quantity = scanner.nextInt();
                        if (quantity <= 0) System.out.println("Quantity must be positive.");
                    }
                    quantities.add(quantity);

                    scanner.nextLine();

                    System.out.println("Item added successfully.");
                    break;
                case 2:
                    System.out.println("--- Inventory ---");
                    if (sku.size() == 0) {
                        System.out.println("No items in inventory.");
                    } else {
                        System.out.printf("%s %10s %20s %10s %15s\n", "SKU", "Name", "Price($)", "Qty", "Line Total");
                        System.out.println("------------------------------------------------------------------");

                        double totalValue = 0;

                        for (int i = 0; i < sku.size(); i++) {
                            double lineTotal = (prices.get(i) * quantities.get(i));
                            System.out.printf("%d %10s %20.2f %10d %15.2f\n", 
                            sku.get(i),
                            names.get(i),
                            prices.get(i),
                            quantities.get(i),
                            lineTotal);

                            totalValue += (prices.get(i) * quantities.get(i));
                        }

                        System.out.println("------------------------------------------------------------------");
                        System.out.printf("Total Inventory Value: $%.2f\n", totalValue);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye! Exiting Program.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 3.");
            }
        }
        scanner.close();
    }
}