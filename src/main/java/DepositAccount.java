import java.util.Date;

public class DepositAccount extends Account {

    private double interest;

    private Date releaseDate;

    public DepositAccount(String id, int userId, double balance, double interest, Date releaseDate) {
        super(id, AccountType.DEPOSIT_ACCOUNT, userId, balance);
        this.interest = interest;
        this.releaseDate = releaseDate;
    }

    public DepositAccount(AccountCreationContextWithInterest creationContext) {
        super(creationContext.getId(), AccountType.DEPOSIT_ACCOUNT, creationContext.getUserId(), creationContext.getBalance());
        this.interest = creationContext.getInterest();
        this.releaseDate = creationContext.getReleaseDate();
    }

    @Override
    public void applyThemeInSite() {
        throw new RuntimeException("Can't apply theme at the moment...");
    }

    public double getInterest() {
        return interest;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
}
