public class OrderManager {
    private AVLTree orderTree;

    public OrderManager() {
        orderTree = new AVLTree();
    }

    public void addOrder(Order order) {
        orderTree.insert(order);
    }
    public void removeOrder(int orderId) {
        Order orderToRemove = getOrderById(orderId);
        if (orderToRemove != null) {
            orderTree.delete(orderToRemove);
        } else {
            System.out.println("Order not found.");
        }
    }
    public Order getOrderById(int orderId) {
        return searchOrderById(orderTree.getRoot(), orderId);
    }
    public void printOrders(){
        orderTree.print();
    }

    private Order searchOrderById(AVLTree.Node node, int orderId) {
        if (node == null) {
            return null;
        }
        // Check if the current node's order ID matches the target ID
        if (node.data.getOrderId() == orderId) {
            return node.data; // Found the order with the given ID
        }

        // Recursively search in the left and right subtrees
        Order foundOrder = searchOrderById(node.left, orderId);
        if (foundOrder != null) {
            return foundOrder; // If found in the left subtree, return the order
        }
        return searchOrderById(node.right, orderId); // Search in the right subtree

    }

}
