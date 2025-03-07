import java.util.List;

interface TaxStrategy {
    double calculateTax(double amount);
}

class DefaultTaxStrategy implements TaxStrategy {
    private static final double TAX_RATE = 0.15;

    @Override
    public double calculateTax(double amount) {
        return amount * TAX_RATE;
    }
}

class Billing {
    private final TaxStrategy taxStrategy;

    public Billing(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public double calculateSubTotal(List<OrderItem> orderList) {
        return orderList.stream()
                        .mapToDouble(item -> item.getPrice() * item.getQuantity())
                        .sum();
    }

    public double calculateTax(double subTotal) {
        return taxStrategy.calculateTax(subTotal);
    }

    public double calculateTotal(double subTotal) {
        return subTotal + calculateTax(subTotal);
    }

    public void printBill(List<OrderItem> orderList) {
        double subTotal = calculateSubTotal(orderList);
        double tax = calculateTax(subTotal);
        double total = calculateTotal(subTotal);

        System.out.println("********** Bill **********");
        System.out.printf("Sub Total: %.2f SAR%n", subTotal);
        System.out.printf("Tax: %.2f SAR%n", tax);
        System.out.printf("Total: %.2f SAR%n", total);

        if (!orderList.isEmpty()) {
            System.out.println("\nOrdered Items:");
            int id = 1;
            for (OrderItem item : orderList) {
                System.out.printf("%d. %s - %.2f SAR (Qty: %d)%n", id++, item.getName(), item.getPrice(), item.getQuantity());
            }
        }
    }
}
