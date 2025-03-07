import java.util.ArrayList;
import java.util.List;

class OrderManager {
    private List<OrderItem> orderList = new ArrayList<>();

    
    public void addOrderItem(OrderItem item) {
        orderList.add(item);
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public void clearOrder() {
        orderList.clear();
    }

    public void displayOrder() {
        if (orderList.isEmpty()) {
            System.out.println("No items in the order.");
            return;
        }
        System.out.println("\nCurrent Order:");
        int id = 1;
        for (OrderItem item : orderList) {
            System.out.printf("%d. %s - %.2f SAR (Qty: %d) Total: %.2f%n",
                id++, item.getName(), item.getPrice(), item.getQuantity(), item.calculateTotal());
        }
    }

    public boolean isOrderEmpty() {
        return orderList.isEmpty();
    }

    public void removeOrderItem(int index) {
        if (index >= 0 && index < orderList.size()) {
            orderList.remove(index);
        }
    }
}
