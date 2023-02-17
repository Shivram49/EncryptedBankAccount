package assign2;

import java.util.Random;
/**

 This class provides methods to test the functionality of the Encryptor class by generating random offsets and encrypting and decrypting various inputs.
 */
public class EncryptionTester {
    /**
     * This method prints the encrypted and decrypted strings for an array of Encryptor objects for various inputs.
     * @param encryptors An array of Encryptor objects for which the encryption and decryption is to be tested.
     */
    public static void printEncryptedAndDecrypted(Encryptor[] encryptors){
        for(Encryptor encryptor : encryptors) {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("encrypted with offset:" + encryptor.getOffset());
            System.out.println("Encrypted :" + encryptor.encrypt("abcdefghijklmnopqrstuvwxyz"));
            System.out.println("Decrypted :" + encryptor.decrypt(encryptor.encrypt("abcdefghijklmnopqrstuvwxyz")));
            System.out.println("Encrypted :" + encryptor.encrypt("Shivram Krishnamurthy"));
            System.out.println("Decrypted :" + encryptor.decrypt(encryptor.encrypt("Shivram Krishnamurthy")));
            System.out.println("Encrypted :" + encryptor.encrypt("Xray defraction"));
            System.out.println("Decrypted :" + encryptor.decrypt(encryptor.encrypt("Xray defraction")));
            System.out.println("Encrypted :" + encryptor.encrypt("Zebra-tailed lizard"));
            System.out.println("Decrypted :" + encryptor.decrypt(encryptor.encrypt("Zebra-tailed lizard")));
            System.out.println("Encrypted :" + encryptor.encrypt("Walkie-talkie"));
            System.out.println("Decrypted :" + encryptor.decrypt(encryptor.encrypt("Walkie-talkie")));
            System.out.println("Encrypted :" + encryptor.encrypt("COEN 275 OO Analysis, Design and Programming"));
            System.out.println("Decrypted :" + encryptor.decrypt(encryptor.encrypt("COEN 275 OO Analysis, Design and Programming")));
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
    }
    /**
     * This method tests the functionality of the Encryptor class for fixed offsets.
     */
    public static void testSet1(){

        //created an instance of Encryptor and
        // set the offset to the values given
        //Values that error out are commented out.
        Encryptor encryptor1 = new Encryptor();
        encryptor1.setOffset(0);
        Encryptor encryptor2 = new Encryptor();
        encryptor2.setOffset(3);
        Encryptor encryptor3 = new Encryptor();
        encryptor3.setOffset(11);
        Encryptor encryptor4 = new Encryptor();
        encryptor4.setOffset(25);
        Encryptor encryptor5 = new Encryptor();
        encryptor5.setOffset(26);
        Encryptor[] encryptors = new Encryptor[3];
        encryptors[0] = encryptor2;
        encryptors[1] = encryptor3;
        encryptors[2] = encryptor4;
        printEncryptedAndDecrypted(encryptors);



    }
    /**
     * This method tests the functionality of the Encryptor class for random offsets.
     */
    public static void testSet2(){
        Encryptor[] encryptors = new Encryptor[4];
        for(int i = 0;i < 4;i++) {
            encryptors[i] = new Encryptor();
            encryptors[i].setOffset((int)(1 + Math.floor(Math.random() * 25)));
        }
        printEncryptedAndDecrypted(encryptors);
    }
/**
 * The main method of this class runs two tests on the Encryptor class using the testSet1() and testSet2() methods.
 * @param args
 **/
    public static void main(String[] args) {

        System.out.println("testset 1");
        testSet1();
        System.out.println("testset 2");
        testSet2();
//        Encryptable encryptable = EncryptionFactory.createEncryptor("RSA");
    }
}
