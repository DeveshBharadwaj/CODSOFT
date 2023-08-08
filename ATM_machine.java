package CodSoftIntern;

import java.util.Scanner;
class AccountBalance{
    public double balance;
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$ " + amount +" has deposit succesfully");
        } else {
            System.out.println("Invalid Amount.");
        }
    }
    public void checkBalance() {
        System.out.println("Your AccountBalance is: $" + this.balance);
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$ " + amount + " Withdrawn Successfully.");
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}
public class ATM_machine {
    Scanner sc=new Scanner(System.in);
    public AccountBalance Account;
    public ATM_machine(double initialbalance){
         Account= new AccountBalance();
        Account.setBalance(initialbalance);
    }
    public void displaymenu(){
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance \n 2. Deposit \n 3. Withdraw \n 4. Exit");
    }
    public  void menu(){
        int choice;
        double amount;
        do{
            displaymenu();
            System.out.println("Select an option 1-4");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    Account.checkBalance();
                    break;
                case 2:
                    System.out.println("Enter  Deposit amount ");
                    amount=sc.nextDouble();
                    Account.deposit(amount);
                    break;
                case 3:
                    System.out.println("Enter Withdraw amount ");
                    amount=sc.nextDouble();
                    Account.withdraw(amount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank You!");
                    break;
            }
        }while (choice<4);
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println(" Input Initial Balance");
        double initialBalance=s.nextDouble();
        ATM_machine atm=new ATM_machine(initialBalance);
        atm.menu();
        s.close();
    }
}
