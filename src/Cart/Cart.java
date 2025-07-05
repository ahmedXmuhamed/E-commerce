package Cart;
import Products.Product;
import User.Customer;
import Products.ExpirableProduct;
import Products.ShippableProduct;
import Products.ShippableExpirableProduct;
import java.util.ArrayList;
import java.util.List;
import Interfaces.IShippableInfo;

public class Cart {
    private List<Item> items;

    // Constructor
    public Cart() {
        this.items = new ArrayList<>();
    }

    // Add a product to the cart with a specified quantity
    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product must not be null and quantity must be positive.");
        }
        items.add(new Item(product, quantity));
    }

    // Calculate total price of all items
    public double getSubtotal() {
        double subtotal = 0;
        for (Item item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    // Check if the cart is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Get all products in the cart
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (Item item : items) {
            products.add(item.getProduct());
        }
        return products;
    }

    // Get all shippable products from the cart
    public List<IShippableInfo> getShippableItems() {
        List<IShippableInfo> shippables = new ArrayList<>();
        for (Item item : items) {
            Product product = item.getProduct();
            if (product instanceof IShippableInfo) {
                shippables.add((IShippableInfo) product);
            }
        }
        return shippables;
    }

}

