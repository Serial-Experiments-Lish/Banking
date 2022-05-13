import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static int input;
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<BankAccount> account = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        account.add(new BankAccount("Matt", 3000, 0));
        account.add(new BankAccount("Julian", 4000, 1));
        account.add(new BankAccount("Hector", 5000, 2));

        System.out.println("Hello world! Welcome to the bank of Matt!");
        System.out.println("Are you an existing customer? (-1 exit)");
        System.out.println("1. Yes");
        System.out.println("2. No");
        input = scanner.nextInt();

        if (input == 1) {
            System.out.println("What is your account number?");
            double accountNum;
            accountNum = scanner.nextDouble();
            if (accountNum < 0 || accountNum > account.size() - 1) {
                System.out.println("Sorry, I could not locate your account number.");
            } else {
                mainMenu(account.get((int) accountNum));
            }

        } else if (input == 2) {
            System.out.println("Let's make a new account!");
            BankAccount newAccount = new BankAccount();

            account.add(newAccount);
            newAccount.setAccountNumber(account.size() - 1);

            System.out.println("What name would you like to use for this account?");
            newAccount.setAccountHolder(scanner.nextLine());

            System.out.println("What is the entry balance for this account?");
            newAccount.setAccountBalance(scanner.nextDouble());
            mainMenu(newAccount);
        }
    }

    public static void mainMenu(BankAccount menu) {
        boolean data = true;
        System.out.println("Hello " + menu.getAccountHolder());
        System.out.println("Welcome to the Main Menu, what would you like to do today?");
        while (data) {
            System.out.println("1. To check account balance");
            System.out.println("2. To make a withdraw");
            System.out.println("3. To make a deposit");
            System.out.println("4. To make a transfer to another account");
            System.out.println("0. To exit");
            
            switch (input) {
                case 1:
                    System.out.println("The name on the account is: " + menu.getAccountHolder() + " and they have a balance of $" + menu.getAccountBalance());
                    break;
                case 2:
                    System.out.println("Please enter the amount to withdraw?");
                    double withdrawalAmount = scanner.nextDouble();
                    
                    menu.withdrawal(withdrawalAmount);
                    System.out.println("You have successfully withdrawn $" + withdrawalAmount + ", your new balance is: $" + menu.getAccountBalance());
                    break;
                case 3:
                    System.out.println("Please enter the amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    
                    menu.deposit(depositAmount);
                    System.out.println("You have successfully deposited $" + depositAmount + ", your new balance is: $" + menu.getAccountBalance());
                    break;
                case 4:
                    System.out.println("Please enter the account number to transfer to:");
                    int accountNum;
                    double transferAmount;
                    
                    accountNum = scanner.nextInt();
                    transferAmount = scanner.nextDouble();
                    
                    menu.transfer(account.get(accountNum), transferAmount);
                    System.out.println("The name on the account is: " + account.get(accountNum).getAccountHolder() + 
                    " , and they have a new balance of $" + account.get(accountNum).getAccountBalance());
                    break;
                case 0:
                    break;
            }
        }
    }
}
