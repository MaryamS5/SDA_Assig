import java.util.List;
import java.util.Scanner;


interface ProductHandler {
    void addProductOrder(OrderManager orderManager, Scanner input);
}


class CoffeeHandler implements ProductHandler {
    private static final String[] coffeeTypes = {"Mocha", "Latte", "Black"};
    private static final double[] prices = {15, 18, 5};

    @Override
    public void addProductOrder(OrderManager orderManager, Scanner input) {
        System.out.println("[1]Mocha (15 SAR)  [2]Latte (18 SAR)  [3]Black (5 SAR)");
        System.out.print("Choice: ");
        int choice = input.nextInt();
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice! Try again.");
            return;
        }
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        orderManager.addOrderItem(new ConcreteOrderItem(coffeeTypes[choice - 1], prices[choice - 1], quantity));

    }
}

class BakeryHandler implements ProductHandler {
    private static final String[] bakeryTypes = {"Bagel", "Bread", "Donut"};
    private static final double[] prices = {19, 6, 13};

    @Override
    public void addProductOrder(OrderManager orderManager, Scanner input) {
        System.out.println("[1]Bagel (19 SAR)  [2]Bread (6 SAR)  [3]Donut (13 SAR)");
        System.out.print("Choice: ");
        int choice = input.nextInt();
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice! Try again.");
            return;
        }
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        orderManager.addOrderItem(new ConcreteOrderItem(bakeryTypes[choice - 1], prices[choice - 1], quantity));

    }
}


public class Employee {
    private Scanner input = new Scanner(System.in);
    private OrderManager orderManager = new OrderManager();
    private Billing billing = new Billing(new DefaultTaxStrategy());

    private ProductHandler coffeeHandler = new CoffeeHandler();
    private ProductHandler bakeryHandler = new BakeryHandler();

    public void addOrder() {
        System.out.println("New Order? [1]Yes  [2]No");
        System.out.print("Choice: ");
        if (input.nextInt() == 1) {
            orderManager.clearOrder();
        }

        while (true) {
            System.out.println("[1]Add Coffee  [2]Add Bakery  [3]Back");
            System.out.print("Choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                coffeeHandler.addProductOrder(orderManager, input);
            } else if (choice == 2) {
                bakeryHandler.addProductOrder(orderManager, input);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public void displayOrder() {
        orderManager.displayOrder();
    }

    public void cancelOrder() {
        if (orderManager.isOrderEmpty()) {
            System.out.println("No items to cancel.");
            return;
        }
        orderManager.displayOrder();
        System.out.print("Enter the item number to remove (or 0 to go back): ");
        int removeIndex = input.nextInt();
        if (removeIndex > 0 && removeIndex <= orderManager.getOrderList().size()) {
            orderManager.removeOrderItem(removeIndex - 1);
            System.out.println("Item removed successfully.");
            orderManager.displayOrder();
        } else {
            System.out.println("Invalid choice! Returning to menu.");
        }
    }

    public void printBill() {
        billing.printBill(orderManager.getOrderList());
    }

    public void displayMenu(List<Menu> products) {
        System.out.println("\n********** Menu **********");
        for (Menu item : products) {
            System.out.printf("%d. %s - %.2f SAR%n", item.getId(), item.getName(), item.getPrice());
        }
    }
}
