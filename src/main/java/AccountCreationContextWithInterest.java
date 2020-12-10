import java.util.Date;

public class AccountCreationContextWithInterest {

    private String id;

    private int userId;

    private double balance;

    private double interest;

    private Date releaseDate;

    public AccountCreationContextWithInterest(String id, int userId, double balance, double interest, Date releaseDate) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.interest = interest;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterest() {
        return interest;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
}
