package Interfaces;
import java.time.LocalDate;

public interface IExpirable {
    LocalDate getExpirationDate();
    boolean isExpired();
}
