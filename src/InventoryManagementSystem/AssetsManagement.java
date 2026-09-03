package InventoryManagementSystem;

import java.util.Scanner;

public class AssetsManagement {
    int currentIndexPosition = 0;
    private int productId = 0;

    public void addProduct(AssetsStorage[] assetsStorages, Scanner scanner) {
        boolean isValid = true;
        String name = "";
        double price = 0;
        int quantity = 0;

        System.out.print("Set Name for a product: ");
        name = scanner.nextLine();
        while (isValid) {
            System.out.print("Set a price for the product: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                isValid = false;
            } else {
                String invalidInput = scanner.next();
                System.out.println(invalidInput + ": is invalid price type");
            }

        }

        isValid = true;
        while (isValid) {
            System.out.print("Set a quantity of product: ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                isValid = false;
            } else {
                String invalidInput = scanner.next();
                System.out.println(invalidInput + ": is a invalid quantity type");
            }
        }

        if (assetsStorages.length == currentIndexPosition) {
            System.out.println("Out of memory");
        } else {
            productId++;
            assetsStorages[currentIndexPosition] = new AssetsStorage(productId, name, price, quantity);
            currentIndexPosition++;
        }
    }

    public void getAllProduct(AssetsStorage[] assetsStorages) {
        for (int i = 0; i < currentIndexPosition; i++) {
            System.out.println(assetsStorages[i].getId() + " " + assetsStorages[i].getName() + " " + assetsStorages[i].getQuantity() + " " + assetsStorages[i].getPrice());
        }
    }

    public void searchProduct(AssetsStorage[] assetsStorages, Scanner scanner) {
        boolean notFound = true;
        System.out.print("Enter a product name to search for product: ");
        String name = scanner.nextLine();

        for (int i=0;i<currentIndexPosition;i++) {
            if(assetsStorages[i].getName().toLowerCase().equalsIgnoreCase(name)) {
                System.out.println(assetsStorages[i].getId() + " " + assetsStorages[i].getName() + " " + assetsStorages[i].getQuantity() + " " + assetsStorages[i].getPrice());
                notFound = false;
            }
        }

        if (notFound) {
            System.out.println("Product not found");
        }
    }

    public void updateProduct(AssetsStorage[] assetsStorages, Scanner scanner) {

    }

    public void addStock(AssetsStorage[] assetsStorages, Scanner scanner) {

    }

    public void sellProduct(AssetsStorage[] assetsStorages, Scanner scanner) {

    }

    public void deleteProduct(AssetsStorage[] assetsStorages, Scanner scanner) {

    }

    public void getLowStockProduct() {

    }

    public void launcher() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        AssetsStorage[] assetsStorages = new AssetsStorage[10];

        while (isRunning) {
            System.out.println();
            System.out.println("1. Add Product");
            System.out.println("2. Get All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Add Stock");
            System.out.println("6. Sell Product");
            System.out.println("7. Delete Product");
            System.out.println("8. Get Low Stock Products");
            System.out.println("9. Exit");

            System.out.print("Please choose an operation: ");
            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();
                scanner.nextLine();

                switch (userChoice) {
                    case 1 -> addProduct(assetsStorages, scanner);
                    case 2 -> getAllProduct(assetsStorages);
                    case 3 -> searchProduct(assetsStorages, scanner);
                    case 4 -> updateProduct(assetsStorages, scanner);
                    case 5 -> addStock(assetsStorages, scanner);
                    case 6 -> sellProduct(assetsStorages, scanner);
                    case 7 -> deleteProduct(assetsStorages, scanner);
                    case 8 -> getLowStockProduct();
                    case 9 -> isRunning = false;
                    default -> System.out.println("Invalid choice please choose listed number only");
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println("Invalid input choose one the option");
            }
        }

    }
}
