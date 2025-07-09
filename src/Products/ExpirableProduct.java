package Products;
import java.time.LocalDate;
import Interfaces.IExpirable;

public class ExpirableProduct extends Product implements IExpirable {
    private LocalDate expirationDate;


    public ExpirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
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

