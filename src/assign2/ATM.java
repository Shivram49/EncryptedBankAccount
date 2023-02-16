package assign2;

import java.util.ArrayList;
/*@javadoc
* ATM class for Question 4
*  */
public class ATM {
    private ArrayList<BankAccount> accounts;
    private Encryptor passwordEncoder;

    public ATM() {
        this.accounts = new ArrayList<>();
        this.passwordEncoder = new Encryptor(15);
    }

    private boolean isAccountPresent(String acctid){
        for(BankAccount account : this.accounts){
            if(account.getAcctid().equals(acctid))
                return true;
        }
        return false;
    }
    public void addAccount(String acctId, String name,double balance, String password){
        if(isAccountPresent(acctId)){
            System.out.println("Account already present");
            return;
        }
        String encryptedPassword = passwordEncoder.encrypt(password);
        BankAccount newAccount = new BankAccount(acctId,name,balance,encryptedPassword);
        accounts.add(newAccount);
    }

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

    private BankAccount searchAccount(String acctid){
        for(BankAccount account : accounts){
            if(account.getAcctid().equals(acctid)){
                return account;
            }
        }
        System.err.println("Incorrect account id");
        return null;
    }

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
