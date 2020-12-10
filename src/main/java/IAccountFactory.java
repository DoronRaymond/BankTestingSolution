import java.util.Date;

public interface IAccountFactory {

    Account create(AccountType accountType, String id, int userId, double balance);

    Account create(AccountType accountType, String id, int userId, double balance, double interest, Date releaseDate);
}
