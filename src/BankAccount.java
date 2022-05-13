public class BankAccount {
    private String accountHolder;
    private double accountBalance;
    private double accountNumber;

    public BankAccount() {}

    public BankAccount(String holder, double balance, double number) {
        this.accountHolder = holder;
        this.accountBalance = balance;
        this.accountNumber = number;
    }
    public void setAccountHolder(String holder) {
        this.accountHolder = holder;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public void setAccountBalance(double balance) {
        this.accountBalance = balance;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountNumber(double number) {
        this.accountNumber = number;
    }    
    public double getAccNumber() {
        return accountNumber;
    }
    public void deposit(double deposit) {
        accountBalance += deposit;
    }
    public void withdrawal(double withdrawal) {
        accountBalance -= withdrawal;
    }
    public void transfer(BankAccount checking, double amount) {
        this.withdrawal(amount);
        checking.deposit(amount);
    }

}