
import java.util.Scanner;

public class BankEngine {

    public static void main(String[] args) {

        BankManagement bank = new BankManagement();
        Scanner scanner = new Scanner(System.in);

        bank.addAccount(new SavingsAccount("SAV101", "Alice Smith", 500.0, 0.04));
        bank.addAccount(new CheckingAccount("CHK101", "Charlie Brown", 1000.0));

        while (true) {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Create Savings Account");
            System.out.println("3. Create Checking Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. View All Transactions");
            System.out.println("7. View Account Transactions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid menu number.");
                continue;
            }

            if (choice == 8) {
                System.out.println("Thank you for using our banking system.");
                break;
            }

            switch (choice) {
                case 1:
                    bank.displayAllAccounts();
                    break;

                case 2:
                case 3:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.print("Enter account holder name: ");
                    String holderName = scanner.nextLine();

                    System.out.print("Enter initial balance: ");

                    try {
                        double balance = Double.parseDouble(scanner.nextLine());

                        if (!Double.isFinite(balance) || balance < 0
                                || holderName.isBlank()
                                || accountNumber.isBlank()) {
                            System.out.println("Invalid account details.");
                            break;
                        }

                        if (choice == 2) {
                            bank.addAccount(new SavingsAccount(
                                    accountNumber, holderName, balance, 0.04));
                        } else {
                            bank.addAccount(new CheckingAccount(
                                    accountNumber, holderName, balance));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a valid balance.");
                    }
                    break;

                case 4:
                case 5:
                    System.out.print("Enter account number: ");
                    String number = scanner.nextLine();

                    System.out.print("Enter amount: ");

                    try {
                        double amount = Double.parseDouble(scanner.nextLine());

                        if (choice == 4) {
                            bank.deposit(number, amount);
                        } else {
                            bank.withdraw(number, amount);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a valid amount.");
                    }
                    break;

                case 6:
                    bank.displayTransactions();
                    break;

                case 7:
                    System.out.print("Enter account number: ");
                    String historyNumber = scanner.nextLine();
                    bank.displayTransactions(historyNumber);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
