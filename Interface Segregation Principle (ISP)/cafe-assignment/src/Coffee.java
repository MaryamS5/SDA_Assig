
public class Coffee extends Menu {

    
    public Coffee(int id, String name, double price) {
        super(id, name, price, "Coffee");
    }

  
    public Coffee(int id, String name, double price, int quantity) {
        super(id, name, price, quantity, "Coffee");
    }
}
