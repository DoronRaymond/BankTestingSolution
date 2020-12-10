import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TransferServiceTest {

    @Mock
    private Bank bank;

    @Mock
    private ITransferCalculator transferCalculator;

    @InjectMocks
    private TransferService transferService;

    @Test
    public void createTransfer_sendingAccountValid_transferCreatedSuccessfully() {
        CheckingAccount checkingAccount = Mockito.mock(CheckingAccount.class);
        Mockito.when(checkingAccount.getAccountId()).thenReturn("1");
        Mockito.when(checkingAccount.getAccountType()).thenReturn(AccountType.CHECKING_ACCOUNT);
        Mockito.when(bank.getAccounts()).thenReturn(new HashSet<>(Arrays.asList(checkingAccount)));

        Date transferTimestamp = new Date();
        Transfer expectedResult = new Transfer("1", "2", 100, transferTimestamp);

        Transfer transfer = transferService.createTransfer("1", "2", 100, transferTimestamp);

        Assert.assertEquals(transfer, expectedResult);
    }

    @Test
    public void releaseDeposit_depositAccountProvided_accountReleasedSuccessfully() {
        DepositAccount depositAccount = Mockito.mock(DepositAccount.class);
        Mockito.when(depositAccount.getAccountId()).thenReturn("1");
        Mockito.when(depositAccount.getAccountType()).thenReturn(AccountType.DEPOSIT_ACCOUNT);
        Mockito.when(bank.getAccounts()).thenReturn(new HashSet<>(Arrays.asList(depositAccount)));

        Mockito.when(transferCalculator.calculateBalanceWithInterest(depositAccount)).thenReturn(400d);

        Account resultAccount = transferService.releaseDeposit("1");

        Assert.assertEquals(resultAccount, depositAccount);
    }
}