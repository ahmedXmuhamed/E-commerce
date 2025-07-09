package Cart;
import Products.Product;

public class Item {
    private Product product;
    private int quantity;


    public Item(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        this.product = product;
        this.quantity = quantity;
    }


    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // Total price for this item (unit price × quantity)
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

