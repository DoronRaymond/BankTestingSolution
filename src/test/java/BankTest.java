import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.ObjectProvider;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class BankTest {

    @Mock
    private IAccountRepository accountRepository;

    @Mock
    private IAccountValidator accountValidator;

    @Mock
    private IAccountFactory accountFactory;

    @Mock
    private ObjectProvider<AccountValidationContext> accountValidationContextProvider;

    @InjectMocks
    private Bank bank;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createCheckingAccount_goodData_OneAccountAddedToBank() {
        Mockito.when(
                this.accountFactory.create(
                        Mockito.eq(AccountType.CHECKING_ACCOUNT), Mockito.anyString(), Mockito.anyInt(), Mockito.anyDouble()))
                .thenReturn(Mockito.mock(CheckingAccount.class));

        this.bank.createCheckingAccount(1, 1);
        Assert.assertEquals(this.bank.getAccounts().size(), 1);
    }

    @Test
    public void createDepositAccount_goodData_oneAccountAddedToBank() {
        Mockito.when(
                this.accountFactory.create(
                        Mockito.eq(AccountType.DEPOSIT_ACCOUNT), Mockito.anyString(), Mockito.anyInt(), Mockito.anyDouble(), Mockito.anyDouble(), Mockito.any(Date.class)))
                .thenReturn(Mockito.mock(DepositAccount.class));

        this.bank.createDepositAccount(1, 1, 1, new Date());
        Assert.assertEquals(this.bank.getAccounts().size(), 1);
    }

























    @Test
    public void validateAccount_allValid_validationSuccessful() {
        AccountValidationContext validationContext = Mockito.mock(AccountValidationContext.class);
        Mockito.when(validationContext.isUserValid()).thenReturn(true);
        Mockito.when(validationContext.isAccountTypeValid()).thenReturn(true);
        Mockito.when(validationContext.isAccountBalanceValid()).thenReturn(true);
        Mockito.when(accountValidationContextProvider.getObject(Mockito.any(Account.class)))
                .thenReturn(validationContext);

        boolean result = this.bank.validateAccount(Mockito.mock(Account.class));

        Assert.assertEquals(result, true);
    }
}