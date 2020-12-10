public class AccountCreationContext {

    private String id;

    private int userId;

    private double balance;

    public AccountCreationContext(String id, int userId, double balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
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
}
