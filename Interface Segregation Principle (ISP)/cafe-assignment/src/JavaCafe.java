import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class JavaCafe {
    private static ArrayList<Menu> products;
    private static Scanner input = new Scanner(System.in);
    private static Employee employee = new Employee();
    private static Customer customer = new Customer(new DefaultRatingService(), new DefaultPaymentService());

    private static Items items = new Items();

    public static void main(String[] args) {
        System.out.println("*************** Welcome to Java Cafe ***************");
        initializeProducts(); 
        
        int choice;
        do {
            displayChoices();
            choice = input.nextInt();
            handleChoice(choice);
        } while (choice != 5); 
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1 -> viewMenu();
            case 2 -> orderServices();
            case 3 -> employee.printBill();
            case 4 -> customerServices();
            case 5 -> System.out.println("Exiting Java Cafe. Thank you!");
            default -> System.out.println("Invalid choice, try again!");
        }
    }

    private static void viewMenu() {
        employee.displayMenu(products); 
        System.out.println("[1] View Product Info    [2] Back");
        System.out.print("Choice: ");
        int subChoice = input.nextInt();

        if (subChoice == 1) {
            items.productInfo();
        } else if (subChoice != 2) {
            System.out.println("Invalid choice, try again!");
        }
    }

    private static void orderServices() {
        System.out.println("[1] Add Order    [2] Display Order    [3] Cancel Order    [4] Back");
        System.out.print("Choice: ");
        int subChoice = input.nextInt();

        switch (subChoice) {
            case 1 -> employee.addOrder();
            case 2 -> employee.displayOrder();
            case 3 -> employee.cancelOrder();
            case 4 -> {} // Do nothing (back)
            default -> System.out.println("Invalid choice, try again!");
        }
    }

    private static void customerServices() {
        System.out.println("[1] Rate Service    [2] Make Payment    [3] Back");
        System.out.print("Choice: ");
        int subChoice = input.nextInt();

        switch (subChoice) {
            case 1 -> customer.rateService();
            case 2 -> customer.payOrder();
            case 3 -> {} 
            default -> System.out.println("Invalid choice, try again!");
        }
    }

    private static void displayChoices() {
        System.out.println("\n[1] View Menu    [2] Order Services    [3] Print Bill    [4] Customer Service    [5] Exit");
        System.out.print("Choice: ");
    }

    private static void initializeProducts() {
        products = new ArrayList<>();
        products.add(new Coffee(1, "Mocha", 15));
        products.add(new Coffee(2, "Latte", 18));
        products.add(new Coffee(3, "Black", 5));
        products.add(new Bakery(4, "Bagel", 19));
        products.add(new Bakery(5, "Bread", 6));
        products.add(new Bakery(6, "Donut", 13));
    }
} 