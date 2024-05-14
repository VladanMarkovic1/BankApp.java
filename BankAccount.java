public class BankAccount {
    
    private static String accountNumber;
    private static double balance;
    BankAccount(String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
return balance;
    }

    public void deposit(double amount){
balance += amount;
System.out.println("Deposit of " + amount + " sucessful." + " New balamce is $" + balance);
    }

    public static void withdraw(double amount){
        if (amount > balance) {
            System.out.println("Withdrawal amount exceeds available balance. Maximum withdrawal amount: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
        }
    }
} 


