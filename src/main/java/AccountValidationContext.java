public class AccountValidationContext {

    private Account account;

    private boolean isUserValid;

    private boolean isAccountTypeValid;

    private boolean isAccountBalanceValid;

    public AccountValidationContext(Account account) {
        this.account = account;
    }

    public AccountValidationContext() {
        isUserValid = false;
        isAccountTypeValid = false;
        isAccountBalanceValid = false;
    }

    public boolean isUserValid() {
        return isUserValid;
    }

    public void setUserValid(boolean userValid) {
        isUserValid = userValid;
    }

    public boolean isAccountTypeValid() {
        return isAccountTypeValid;
    }

    public void setAccountTypeValid(boolean accountTypeValid) {
        isAccountTypeValid = accountTypeValid;
    }

    public boolean isAccountBalanceValid() {
        return isAccountBalanceValid;
    }

    public void setAccountBalanceValid(boolean accountBalanceValid) {
        isAccountBalanceValid = accountBalanceValid;
    }
}
