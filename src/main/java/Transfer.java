import java.util.Date;
import java.util.Objects;

public class Transfer {

    private String sendingAccount;

    private String receivingAccount;

    private double amount;

    private Date timestamp;

    public Transfer(String sendingAccount, String receivingAccount, double amount, Date timestamp) {
        this.sendingAccount = sendingAccount;
        this.receivingAccount = receivingAccount;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getSendingAccount() {
        return sendingAccount;
    }

    public String getReceivingAccount() {
        return receivingAccount;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sendingAccount, receivingAccount, amount, timestamp);
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;

        if (this == obj) {
            isEquals = true;
        } else if (obj instanceof Transfer) {
            Transfer transfer = (Transfer) obj;

            isEquals = receivingAccount.equals(transfer.receivingAccount) &&
                    sendingAccount.equals(transfer.sendingAccount) &&
                    amount == transfer.amount &&
                    timestamp == transfer.timestamp;
        }

        return isEquals;
    }
}
