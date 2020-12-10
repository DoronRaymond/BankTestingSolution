public interface IAccountValidator {

    void validate(AccountValidationContext validationContext);

    void checkAccountUser(AccountValidationContext validationContext);

    void checkAccountType(AccountValidationContext validationContext);

    void checkAccountBalance(AccountValidationContext validationContext);
}
