package assign2;

public class BankAccount {
    private String acctid;
    private String name;
    private double balance;
    private String password;

    public BankAccount(String acctid, String name, double balance, String password) {
        this.acctid = acctid;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    public String getAcctid() {
        return acctid;
    }

    public void setAcctid(String acctid) {
        this.acctid = acctid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double withDraw(double amount){
        if(amount <= 0 || amount > this.balance){
            System.out.println("Enter an amount in the range within your balance");
            return 0.0;
        }
        this.balance -= amount;
        return amount;
    }

    public void deposit(int amount){
        if(amount <= 0){
            System.out.println("Enter an amount in the range within your balance");
            return;
        }
        this.balance += amount;
    }
}
