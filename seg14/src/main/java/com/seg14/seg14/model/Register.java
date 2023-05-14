import java.util.Date;

public abstract class Register {
    private double amount;
    private String description;
    private Date regDate;

    public Register(double amount, String description, Date regDate) {
        this.amount = amount;
        this.description = description;
        this.regDate = regDate;
    }
}
