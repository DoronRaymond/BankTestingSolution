
public class CheckingAccount extends Account {

    public CheckingAccount(String id, int userId, double balance) {
        super(id, AccountType.CHECKING_ACCOUNT, userId, balance);
    }

    public CheckingAccount(AccountCreationContext creationContext) {
        super(creationContext.getId(), AccountType.CHECKING_ACCOUNT, creationContext.getUserId(), creationContext.getBalance());
    }

    @Override
    public void applyThemeInSite() {
        throw new RuntimeException("Can't apply theme at the moment...");
    }
}
