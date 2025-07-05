import  Cart.Cart;
import Products.Product;
import User.Customer;
import Products.ExpirableProduct;
import Products.ShippableProduct;
import Products.ShippableExpirableProduct;
import Services.CheckoutService;
import Services.ShippingService;
import java.time.LocalDate;
import Interfaces.IShippableInfo;

public class Main {
    public static void main(String[] args) {
        // Create products
        ExpirableProduct cheese = new ExpirableProduct(
                "Cheese",
                15.0,
                50,
                LocalDate.now().plusDays(5)
        );

        ShippableProduct tv = new ShippableProduct(
                "Smart TV",
                300.0,
                10,
                10.5 // kg
        );

        Product scratchCard = new Product(
                "Scratch Card",
                2.0,
                100
        );
        ShippableExpirableProduct food = new ShippableExpirableProduct("food",2.2,2,2.5,LocalDate.now().plusDays(2));

        // Create a customer
        Customer customer = new Customer("Ahmed", 2000.0);

        // Create a cart and add items
        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(tv, 3);
        cart.addProduct(scratchCard, 1);
        cart.addProduct(food, 2);

        // Checkout
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer, cart);

        // Optional: Print shipping notice
        ShippingService shippingService = new ShippingService();
        if (shippingService.hasShippableItems(cart)) {
            shippingService.printShippingNotice(cart.getShippableItems());

        }
    }
}