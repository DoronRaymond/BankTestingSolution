import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class Bank {

    private Set<Account> accounts;

    private IAccountRepository accountRepository;

    private IAccountValidator accountValidator;

    private IAccountFactory accountFactory;

    private ObjectProvider<AccountValidationContext> accountValidationContextProvider;

    @Autowired
    public Bank(
            IAccountRepository accountRepository,
            IAccountValidator accountValidator,
            IAccountFactory accountFactory,
            ObjectProvider<AccountValidationContext> accountValidationContextProvider) {
        accounts = new HashSet<>();
        this.accountRepository = accountRepository;
        this.accountValidator = accountValidator;
        this.accountFactory = accountFactory;
        this.accountValidationContextProvider = accountValidationContextProvider;
    }

    public void createCheckingAccount(int userId, double balance) {
        CheckingAccount account = (CheckingAccount)this.accountFactory.create(
                AccountType.CHECKING_ACCOUNT, UUID.randomUUID().toString(), userId, balance);
        saveNewAccount(account);
    }

    public void createDepositAccount(int userId, double balance, double interest, Date releaseDate) {
        DepositAccount account = (DepositAccount)this.accountFactory.create(
                AccountType.DEPOSIT_ACCOUNT, UUID.randomUUID().toString(), userId, balance, interest, releaseDate);
        saveNewAccount(account);
    }

    private void saveNewAccount(Account account) {
        this.accountRepository.save(account);
        accounts.add(account);
        account.applyThemeInSite();
    }

    public boolean validateAccount(Account account) {
        AccountValidationContext validationContext = this.accountValidationContextProvider.getObject(account);
        accountValidator.validate(validationContext);

        return validationContext.isUserValid() &&
                validationContext.isAccountTypeValid() &&
                validationContext.isAccountBalanceValid();
    }

    public Set<Account> getAccounts() {
        return accounts;
    }
}
