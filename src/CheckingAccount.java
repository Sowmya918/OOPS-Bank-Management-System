
public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, String holderName,
                           double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Account Type: Checking");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Holder Name: " + getHolderName());
        System.out.println("Balance: " + getBalance());
    }
}
