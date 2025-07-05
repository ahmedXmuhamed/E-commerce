package Products;
import Interfaces.IShippableInfo;


public class ShippableProduct extends Product implements IShippableInfo {
    private double weight;

    // Constructor
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    // Implemented from IShippableInfo
    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
