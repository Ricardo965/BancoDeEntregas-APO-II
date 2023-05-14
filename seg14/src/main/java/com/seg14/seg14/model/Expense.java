import java.util.Date;

public class Expense extends Register implements Registrable{
    public Expense(double amount, String description, Date regDate) {
        super(amount, description, regDate);
    }
}
