import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface ItemInfo {
    String getName();
    String getOrigin();
    String getType();
    int getCalories();
    String getDescription();  // ✅ Ensure all subclasses have this method
}

abstract class AbstractItem implements ItemInfo {
    protected String name, origin, type;
    protected int calories;

    public AbstractItem(String name, String origin, String type, int calories) {
        this.name = name;
        this.origin = origin;
        this.type = type;
        this.calories = calories;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getOrigin() { return origin; }

    @Override
    public String getType() { return type; }

    @Override
    public int getCalories() { return calories; }

    @Override
    public String getDescription() { return "No description available."; }  // ✅ Default implementation
}

// CoffeeItem class
class CoffeeItem extends AbstractItem {
    public CoffeeItem(String name, String origin, int calories) {
        super(name, origin, "Coffee", calories);  // ✅ Type added for consistency
    }

    @Override
    public String getDescription() {
        return switch (name) {
            case "Mocha" -> "Shot of espresso combined with chocolate powder or syrup, followed by milk or cream. A variant of a latte.";
            case "Latte" -> "One or two shots of espresso, lots of steamed milk, and a thin layer of frothed milk.";
            case "Black" -> "Coffee with no milk, milk substitute, or cream added.";
            default -> super.getDescription();  // ✅ No LSP violation
        };
    }
}

// BakeryItem class
class BakeryItem extends AbstractItem {
    public BakeryItem(String name, String type, int calories) {
        super(name, "Bakery", type, calories);  // ✅ Origin is "Bakery" for consistency
    }

    @Override
    public String getDescription() {
        return switch (name) {
            case "Bagel" -> "Classic soft, chewy, thick New York–style bagel.";
            case "Bread" -> "Fresh bread made with rye flour served with chocolate or butter.";
            case "Donut" -> "Shaped yeast-leavened roll with a crisp, shiny crust and a dense interior.";
            default -> super.getDescription();  // ✅ No LSP violation
        };
    }
}

// ProductCatalog class to store products
class ProductCatalog {
    private static final Map<Integer, ItemInfo> productCatalog = new HashMap<>();

    static {
        productCatalog.put(1, new CoffeeItem("Mocha", "Yemen", 197));
        productCatalog.put(2, new CoffeeItem("Latte", "Italy", 206));
        productCatalog.put(3, new CoffeeItem("Black", "South Africa", 2));
        productCatalog.put(4, new BakeryItem("Bagel", "Plain", 250));
        productCatalog.put(5, new BakeryItem("Bread", "Rye Bread", 67));
        productCatalog.put(6, new BakeryItem("Donut", "Classic", 190));
    }

    public static ItemInfo getProductInfo(int id) {
        return productCatalog.get(id);
    }
}

public class Items {
    public void productInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter product ID: ");
        int id = input.nextInt();

        ItemInfo item = ProductCatalog.getProductInfo(id);

        if (item == null) {
            System.out.println("Invalid Number, Try Again!!");
            return;
        }

        System.out.println("\n********************* Product Info *********************");
        System.out.println("Name: " + item.getName());

        if (item.getOrigin() != null) {
            System.out.println("Place of Origin: " + item.getOrigin());
        }
        if (item.getType() != null) {
            System.out.println("Type: " + item.getType());
        }
        System.out.println("Calories: " + item.getCalories());
        System.out.println("Description: " + item.getDescription());
    }

    void productInfo(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
