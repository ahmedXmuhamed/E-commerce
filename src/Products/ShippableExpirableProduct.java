package Products;
import Interfaces.IShippableInfo;
import Interfaces.IExpirable;
import java.time.LocalDate;

public class ShippableExpirableProduct extends Product implements IShippableInfo, IExpirable {
    private double weight;
    private LocalDate expirationDate;


    public ShippableExpirableProduct(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}

