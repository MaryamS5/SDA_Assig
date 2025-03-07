
public abstract class Menu {
    protected int id;
    protected String name;
    protected double price;
    protected int quantity;
    protected String category; 

    public Menu(int id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = (quantity > 0) ? quantity : 1;
        this.category = category;
    }

    public Menu(int id, String name, double price, String category) {
        this(id, name, price, 1, category);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { if (quantity > 0) this.quantity = quantity; }

   
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("%d. %s - $%.2f (Qty: %d, Category: %s)", id, name, price, quantity, category);
    }
}
