import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Comment

public interface Bank_Account {
    double getBalance();

    void deposit(double amount);

    void withdraw(double amount);

    void printTransactionHistory();
}

class SavingsAccount implements Bank_Account {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public SavingsAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: +$" + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount. Deposit failed!");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                transactionHistory.add("Withdrawal: -$" + amount);
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient balance. Withdrawal failed!");
            }
        } else {
            System.out.println("Invalid amount. Withdrawal failed!");
        }
    }

    @Override
    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class ATM {
    private Bank_Account bankAccount;

    public ATM(Bank_Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }

    public void viewTransactionHistory() {
        System.out.println("Account Number: " + ((SavingsAccount) bankAccount).getAccountNumber());
        bankAccount.printTransactionHistory();
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("1234567890", 0);
        ATM atm = new ATM(savingsAccount);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("ATM Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter the withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        atm.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        atm.checkBalance();
                        break;
                    case 4:
                        atm.viewTransactionHistory();
                        break;
                    case 5:
                        System.out.println("Exiting ATM...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
