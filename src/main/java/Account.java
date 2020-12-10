import java.util.Date;
import java.util.Objects;

public abstract class Account {

    private String accountId;

    private AccountType accountType;

    private int userId;

    private double balance;

    private Date openingDate;

    public Account(String accountId, AccountType accountType, int userId, double balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.userId = userId;
        this.balance = balance;
        this.openingDate = new Date();
    }

    public abstract void applyThemeInSite();

    public String getAccountId() {
        return accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;

        if (this == obj) {
            isEquals = true;
        } else if (obj instanceof Account) {
            Account account = (Account) obj;

            isEquals = accountId.equals(account.getAccountId());
        }

        return isEquals;
    }
}
