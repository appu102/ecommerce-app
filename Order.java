public class Order {
    private User user;
    private Product product;
    private int quantity;

    public Order(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return user.getUsername() + " ordered " + quantity + " x " + product.getName();
    }
}
