public class Bakery extends Menu {
    public Bakery(int id, String name, double price) {
        super(id, name, price, "Bakery");
    }

    public Bakery(int id, String name, double price, int quantity) {
        super(id, name, price, quantity, "Bakery");
    }
}
