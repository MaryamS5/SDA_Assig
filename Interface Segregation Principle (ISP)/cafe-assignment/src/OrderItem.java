
abstract class OrderItem {
    private String name;
    private double price;
    private int quantity;

    public OrderItem(String name, double price, int quantity) {
        this.name = name;
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

    
    public abstract double calculateTotal();
}


class ConcreteOrderItem extends OrderItem {
    public ConcreteOrderItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotal() {
        return getPrice() * getQuantity();
    }
}
