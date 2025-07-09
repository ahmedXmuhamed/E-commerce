package Services;
import  Cart.Cart;
import Products.Product;
import User.Customer;
import Products.ExpirableProduct;
import Products.ShippableProduct;
import Products.ShippableExpirableProduct;
import Interfaces.IShippableInfo;

import java.util.List;

public class CheckoutService {
    private static final double SHIPPING_RATE_PER_KG = 10.0;

    // Calculate shipping cost based on total weight
    public double calculateShippingCost(Cart cart) {
        double totalWeight = 0;
        List<IShippableInfo> shippables = cart.getShippableItems();
        for (IShippableInfo product : shippables) {
            totalWeight += product.getWeight();
        }
        return totalWeight * SHIPPING_RATE_PER_KG;
    }


    // Public method to process the checkout
    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = cart.getSubtotal();
        double shippingCost = calculateShippingCost(cart);
        double total = subtotal + shippingCost;

        customer.withdraw(total); // Deduct from customer's balance

        printReceipt(customer, cart, subtotal, total, shippingCost);
    }

    // Private method to print the receipt , I have made it private to be just method helper
    private void printReceipt(Customer customer, Cart cart, double subtotal, double totalPaid, double shippingFees) {
        System.out.println("===== RECEIPT =====");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Items:");
        for (Product product : cart.getAllProducts()) {
            System.out.printf("- %s (%.2f x %d)%n",
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity());
        }
        System.out.printf("Subtotal: %.2f%n", subtotal);
        System.out.printf("Shipping: %.2f%n", shippingFees);
        System.out.printf("Total Paid: %.2f%n", totalPaid);
        System.out.println("====================");
    }
}

