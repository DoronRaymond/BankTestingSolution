import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository implements IAccountRepository {

    public AccountRepository() {
    }

    public void save(Account account) {
        throw new RuntimeException("Connection to DB doesn't exist");
    }
}
