
import java.util.ArrayList;

public class BankManagement {

    private final ArrayList<BankAccount> accounts = new ArrayList<>();
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public void addAccount(BankAccount account) {
        for (BankAccount existing : accounts) {
            if (existing.getAccountNumber().equalsIgnoreCase(
                    account.getAccountNumber())) {
                System.out.println("Account number already exists.");
                return;
            }
        }

        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (BankAccount account : accounts) {
            System.out.println();
            account.displayAccountDetails();
        }
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (amount <= 0 || !Double.isFinite(amount)) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        double previousBalance = account.getBalance();
        account.deposit(amount);

        if (account.getBalance() > previousBalance) {
            transactions.add(new Transaction(accountNumber, "DEPOSIT", amount));
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (amount <= 0 || !Double.isFinite(amount)) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        double previousBalance = account.getBalance();
        account.withdraw(amount);

        if (account.getBalance() < previousBalance) {
            transactions.add(new Transaction(accountNumber, "WITHDRAWAL", amount));
        }
    }

    public void displayTransactions() {
        displayTransactions(null);
    }

    public void displayTransactions(String accountNumber) {
        boolean found = false;

        for (Transaction transaction : transactions) {
            if (accountNumber == null
                    || transaction.getAccountNumber()
                    .equalsIgnoreCase(accountNumber)) {
                transaction.displayTransaction();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found.");
        }
    }
}
