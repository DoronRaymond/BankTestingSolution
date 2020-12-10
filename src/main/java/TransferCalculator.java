import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class TransferCalculator implements ITransferCalculator {

    public TransferCalculator() {

    }

    public double calculateBalanceWithInterest(DepositAccount depositAccount) {
        long periodInDays = ChronoUnit.DAYS.between(LocalDateTime.now(), depositAccount.getOpeningDate().toInstant());
        double periodInYears = periodInDays == 0 ? 0 : (double)periodInDays / 365;
        double newBalance = depositAccount.getBalance() * (1 + depositAccount.getInterest() * periodInYears);

        if (depositAccount.getReleaseDate().compareTo(new Date()) > 0) {
            newBalance *= 0.80;
        }

        return newBalance;
    }
}
