
public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName,
                          double initialBalance, double interestRate) {
        super(accountNumber, holderName, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() - amount >= 100) {
            setBalance(getBalance() - amount);
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal denied. Minimum balance of 100 must be maintained.");
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Account Type: Savings");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Holder Name: " + getHolderName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate);
    }
}
