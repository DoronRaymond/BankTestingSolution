import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class AccountFactory implements IAccountFactory {

    ObjectProvider<AccountCreationContext> accountCreationContextProvider;

    ObjectProvider<AccountCreationContextWithInterest> accountCreationContextWithInterestProvider;

    private Map<AccountType, Function<AccountCreationContext, Account>> accountCreationMapping;

    private Map<AccountType, Function<AccountCreationContextWithInterest, Account>> accountCreationWithInterestMapping;

    @Autowired
    public AccountFactory(
            ObjectProvider<AccountCreationContext> accountCreationContextProvider,
            ObjectProvider<AccountCreationContextWithInterest> accountCreationContextWithInterestProvider) {

        this.accountCreationContextProvider = accountCreationContextProvider;
        this.accountCreationContextWithInterestProvider = accountCreationContextWithInterestProvider;

        accountCreationMapping = new HashMap<>();
        accountCreationMapping.put(AccountType.CHECKING_ACCOUNT, CheckingAccount::new);

        accountCreationWithInterestMapping = new HashMap<>();
        accountCreationWithInterestMapping.put(AccountType.DEPOSIT_ACCOUNT, DepositAccount::new);
    }

    @Override
    public Account create(AccountType accountType, String id, int userId, double balance) {
        AccountCreationContext creationContext = accountCreationContextProvider.getObject(id, userId, balance);

        Function<AccountCreationContext, Account> supplier = accountCreationMapping.get(accountType);

        Account account = null;

        if (supplier == null) {
            throw new RuntimeException(String.format("No Account Supplier for %s", accountType));
        } else {
            account = supplier.apply(creationContext);
        }

        return account;
    }

    @Override
    public Account create(AccountType accountType, String id, int userId, double balance, double interest, Date releaseDate) {
        AccountCreationContextWithInterest creationContext =
                accountCreationContextWithInterestProvider.getObject(id, userId, balance, interest, releaseDate);

        Function<AccountCreationContextWithInterest, Account> supplier = accountCreationWithInterestMapping.get(accountType);

        Account account = null;

        if (supplier == null) {
            throw new RuntimeException(String.format("No Account Supplier for %s", accountType));
        } else {
            account = supplier.apply(creationContext);
        }

        return account;
    }
}
