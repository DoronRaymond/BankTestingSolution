import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class configuration {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public AccountCreationContext accountCreationContext(String id, int userId, double balance) {
        return new AccountCreationContext(id, userId, balance);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public AccountCreationContextWithInterest accountCreationContextWithInterest(String id, int userId, double balance, double interest, Date releaseDate) {
        return new AccountCreationContextWithInterest(id, userId, balance, interest, releaseDate);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public AccountValidationContext accountValidationContext(Account account) {
        return new AccountValidationContext(account);
    }
}
