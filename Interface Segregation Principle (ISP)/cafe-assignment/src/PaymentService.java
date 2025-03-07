import java.util.Scanner;


interface PaymentMethod {
    boolean process();
}


class CashPayment implements PaymentMethod {
    private final Scanner input = new Scanner(System.in);

    @Override
    public boolean process() {
        System.out.println("Was your cash payment successful?");
        System.out.println("[1] Yes  [2] No");
        System.out.print("Choice: ");
        int paymentStatus = input.nextInt();
        return paymentStatus == 1;
    }
}

class CardPayment implements PaymentMethod {
    @Override
    public boolean process() {
        System.out.println("Processing card payment...");
        System.out.println("Payment successful!");
        return true;
    }
}


public class PaymentService {
    private final Scanner input = new Scanner(System.in);

    public void processPayment(PaymentMethod paymentMethod) {
        int choice;
        while (true) {
            System.out.println("[1] Pay for Order  [2] Back");
            System.out.print("Choice: ");
            choice = input.nextInt();

            if (choice == 1) {
                if (paymentMethod.process()) {
                    System.out.println("Thanks for purchasing.");
                } else {
                    System.out.println("Unsuccessful payment, please try again.");
                }
                break;
            } else if (choice == 2) {
                System.out.println("Returning to main menu...");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
