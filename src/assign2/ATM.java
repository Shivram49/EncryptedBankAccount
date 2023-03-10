package assign2;

import java.util.ArrayList;
import java.util.Collection;

/**

 The ATM class simulates the behavior of an Automated Teller Machine.

 It allows users to create and add a bank account, search for an account, and withdraw money from their account.
 */
public class ATM {
    private ArrayList<BankAccount> accounts;
    private Encryptor passwordEncoder;
    /**
     Constructor for the ATM class. Initializes the accounts ArrayList and sets the encryption offset for the passwordEncoder instance.
     */
    public ATM() {
        this.accounts = new ArrayList<>();
        this.passwordEncoder = new Encryptor();
        this.passwordEncoder.setOffset(25);
//        passwordEncoder = EncryptionFactory.createEncryptor("RSA");
    }
    /**

     Method to check if an account with the specified account ID already exists.
     @param acctid The account ID to search for.
     @return true if the account already exists, false otherwise.
     */
    private boolean isAccountPresent(String acctid){
        for(BankAccount account : this.accounts){
            if(account.getAcctid().equals(acctid))
                return true;
        }
        return false;
    }
    /**

     Method to add a new account to the accounts ArrayList.
     @param acctId The account ID for the new account.
     @param name The name of the account holder.
     @param balance The balance of the account.
     @param password The password for the account.
     */
    public void addAccount(String acctId, String name,double balance, String password){
        if(isAccountPresent(acctId)){
            System.out.println("Account already present");
            return;
        }
        String encryptedPassword = passwordEncoder.encrypt(password);
        BankAccount newAccount = new BankAccount(acctId,name,balance,encryptedPassword);
        accounts.add(newAccount);
    }
    /**

     Method to withdraw money from a specified account, given the correct password.
     @param acctId The account ID of the account to withdraw money from.
     @param password The password for the account.
     @param amount The amount to withdraw.
     @return The amount withdrawn if the withdrawal was successful, 0.0 otherwise.
     */
    public double getMoney(String acctId, String password, double amount){
        BankAccount account = searchAccount(acctId);
        if(account != null){
            if(passwordEncoder.decrypt(account.getPassword()).equalsIgnoreCase(password)){
                return account.withDraw(amount);
            }
            else{
                System.out.println("Incorrect password");
            }
        }
        return 0.0;
    }
    /**

     Method to search for an account in the accounts ArrayList, given the account ID.
     @param acctid The account ID to search for.
     @return The BankAccount object corresponding to the account ID, or null if the account does not exist.
     */
    private BankAccount searchAccount(String acctid){
        for(BankAccount account : accounts){
            if(account.getAcctid().equals(acctid)){
                return account;
            }
        }
        System.err.println("Incorrect account id");
        return null;
    }
    /**

     Main method to run the ATM simulation with some test cases.

     @param args The command-line arguments (unused).
     */
    public static void main(String[] args) {

        //Create an instance of ATM.
        ATM atm = new ATM();

        //Call the addAccount() with the following values for parameters:
        //acctId: A123 name: M.Jones password: fall-quarter balance: 2000.00
        atm.addAccount("A123","M.Jones password",2000.00,"fall-quarter");

        //Call the addAccount() with the following values for parameters:
        //acctId: B654 name: B.Smith password: renaissance balance: 100.00
        atm.addAccount("B654","B.Smith",100.00,"renaissance");

        //Call the getMoney() with the following values for parameters:
        //acctId: A123 password: fall-quarter amount: 1000.00
        System.out.println(atm.getMoney("A123","fall-quarter",1000.00));

        //Call the getMoney() with the following values for parameters:
        //acctId: B654 password: essence amount: 100.00
        System.out.println(atm.getMoney("B654","essence",100.00));

        //Call the getMoney() with the following values for parameters:
        //acctId: B654 password: renaissance amount: 50.00
        //do this 3 times
        System.out.println(atm.getMoney("B654","renaissance",50.00));
        System.out.println(atm.getMoney("B654","renaissance",50.00));
        System.out.println(atm.getMoney("B654","renaissance",50.00));

        //Call the addAccount() with the following values for parameters:
        //acctId: A123 name: M.Jones password: fall-quarter balance: 1000.00
        atm.addAccount("A123","M.Jones password",2000.00,"fall-quarter");

    }
}
