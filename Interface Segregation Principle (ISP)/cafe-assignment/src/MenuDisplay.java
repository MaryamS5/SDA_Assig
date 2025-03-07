import java.util.ArrayList;


interface MenuDisplayStrategy {
    void display(ArrayList<Menu> products);
}


class TextMenuDisplay implements MenuDisplayStrategy {
    @Override
    public void display(ArrayList<Menu> products) {
        System.out.println("********* Menu *********");
        System.out.println("ID    NAME      PRICE    CATEGORY");
        for (Menu item : products) {
            System.out.println(item.getId() + "     " + item.getName() + "     " + item.getPrice() + " SAR    " + item.getCategory());
        }
    }
}


public class MenuDisplay {
    private final MenuDisplayStrategy displayStrategy;

    public MenuDisplay(MenuDisplayStrategy displayStrategy) {
        this.displayStrategy = displayStrategy;
    }

    public void displayMenu(ArrayList<Menu> products) {
        displayStrategy.display(products);
    }
}
