import java.util.Scanner;

public class Bankapp {
  static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.println("Welcome to bank app");

    System.out.println("Enter number of accounts you want to create");
    int numAccounts = scanner.nextInt();
    
   final BankAccount accounts[] = new BankAccount[numAccounts] ;

   for(int i=0; i<numAccounts; i++){
    System.out.println("Enter number for account "+ (i+1) + ":"); 
   String numOfAcc = scanner.next();

   System.out.println("Enter intial balance for account " + (i+1) +  ":");
   int initBalance = scanner.nextInt();
   accounts[i] = new BankAccount(numOfAcc, initBalance);
   }

   while(true){
   System.out.println("MENU");
   System.out.println("1.Deposit");
   System.out.println("2.Withdraw");
   System.out.println("3.CheckBalance");
   System.out.println("4.Exit");

   int choice= scanner.nextInt();

   switch(choice){
case 1:
System.out.println("Enter account number");
String depAccNum = scanner.next();
BankAccount depositAcc = findAccount(accounts, depAccNum);
if(depositAcc!=null){
  System.out.println("Enter your amount");
int depAmount= scanner.nextInt();
Deposit.deposit(depositAcc, depAmount);
}
else{
System.out.println("Account not found!Try again please.");
}
break;
case 2:
System.out.println("Enter account number");
String withdrawAccNum= scanner.next();
BankAccount withdrawAcc= findAccount(accounts, withdrawAccNum);

if(withdrawAcc!= null){
  System.out.println("Enter amount you want to withdraw");
int withdrawAmount = scanner.nextInt();
 Withdraw.withdrawal(withdrawAcc, withdrawAmount);
}
else{
System.out.println("Account not found");
}
break;
case 3:
System.out.println("Enter account number");
String balAccNum = scanner.next();
BankAccount depAcc = findAccount(accounts, balAccNum);
if(depAcc!=null){
CheckBalance.checkBalance(depAcc);
}
else{
System.out.println("Account not found");
}
break;
case 4:
ExitProgram.exit();
  }
}
}
   public static BankAccount findAccount(BankAccount [] accounts, String accountNumber ){
    for(BankAccount account: accounts){
        if(account.getAccountNumber().equals(accountNumber))
        return account;
    }
return null;
}

}
