import java.util.Scanner;
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void withdrawal(double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdrawal'");
    }
}
class Deposit {
    public static void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }
}
class Withdrawal {
    public static void withdraw(BankAccount account, double amount) {
        account.withdraw(amount);
    }
}
class CheckBalance {
    public static void checkBalance(BankAccount account) {
        System.out.println("Balance for account " + account.getAccountNumber() +
                ": $" + account.getBalance());
    }
}
class ExitProgram {
    public static void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of bank accounts: ");
        int numAccounts = scanner.nextInt();

        BankAccount[] accounts = new BankAccount[numAccounts];

        // Initialize bank accounts
        for (int i = 0; i < numAccounts; i++) {
            System.out.print("Enter account number for account " + (i + 1) + ": ");
            String accountNumber = scanner.next();
            System.out.print("Enter initial balance for account " + (i + 1) + ": ");
            double initialBalance = scanner.nextDouble();

            accounts[i] = new BankAccount(accountNumber, initialBalance);
        }

        // Main loop
        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.next();
                    BankAccount depositAccount = findAccount(accounts, depositAccountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        Deposit.deposit(depositAccount, depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.next();
                    BankAccount withdrawAccount = findAccount(accounts, withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        Withdrawal.withdraw(withdrawAccount, withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String checkBalanceAccountNumber = scanner.next();
                    BankAccount checkBalanceAccount = findAccount(accounts, checkBalanceAccountNumber);
                    if (checkBalanceAccount != null) {
                        CheckBalance.checkBalance(checkBalanceAccount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    ExitProgram.exit();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static BankAccount findAccount(BankAccount[] accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
