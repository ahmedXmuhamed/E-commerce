package Services;
import  Cart.Cart;
import Products.Product;
import User.Customer;
import Products.ExpirableProduct;
import Products.ShippableProduct;
import Products.ShippableExpirableProduct;
import Interfaces.IShippableInfo;

import java.util.List;

public class ShippingService {

    // Check if the cart has at least one shippable item
    public boolean hasShippableItems(Cart cart) {
        return !cart.getShippableItems().isEmpty();
    }

    // Print shipping notice for a list of shippable products
    public void printShippingNotice(List<IShippableInfo> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("No items to ship.");
            return;
        }

        System.out.println("===== SHIPPING NOTICE =====");
        for (IShippableInfo product : items) {
            System.out.printf("- %s | Weight: %.2f kg%n",
                    product.getName(), product.getWeight());
        }
        System.out.println("===========================");
    }
}

