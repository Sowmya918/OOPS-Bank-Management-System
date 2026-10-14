
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String accountNumber;
    private String type;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void displayTransaction() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Account: " + accountNumber
                + " | Type: " + type
                + " | Amount: " + amount
                + " | Date: " + dateTime.format(formatter));
    }
}
