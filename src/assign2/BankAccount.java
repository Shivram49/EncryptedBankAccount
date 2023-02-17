
package assign2;

/**

 BankAccount class represents a bank account with account id, name, balance, and password.
 */

public class BankAccount {
    private String acctid; // account id
    private String name; // account holder's name
    private double balance; // balance in the account
    private String password; // password for the account

    /**
     * Creates a new bank account with the given account id, name, balance, and password.
     * @param acctid the account id to be set
     * @param name the account holder's name to be set
     * @param balance the initial balance to be set
     * @param password the password for the account to be set
     */
    public BankAccount(String acctid, String name, double balance, String password) {
        this.acctid = acctid;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    /**
     * Returns the account id of this account.
     * @return the account id of this account
     */
    public String getAcctid() {
        return acctid;
    }

    /**
     * Sets the account id of this account.
     * @param acctid the account id to be set
     */
    public void setAcctid(String acctid) {
        this.acctid = acctid;
    }

    /**
     * Returns the name of the account holder.
     * @return the name of the account holder
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the account holder.
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the password for this account.
     * @return the password for this account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for this account.
     * @param password the password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Withdraws the specified amount from this account and returns the withdrawn amount.
     * @param amount the amount to be withdrawn
     * @return the withdrawn amount
     */
    public double withDraw(double amount){
        if(amount <= 0 || amount > this.balance){
            System.out.println("Enter an amount in the range within your balance");
            return 0.0;
        }
        this.balance -= amount;
        return amount;
    }

    /**
     * Deposits the specified amount to this account.
     * @param amount the amount to be deposited
     */
    public void deposit(int amount){
        if(amount <= 0){
            System.out.println("Enter an amount in the range within your balance");
            return;
        }
        this.balance += amount;
    }
}
