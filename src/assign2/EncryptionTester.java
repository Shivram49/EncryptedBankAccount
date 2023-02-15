package assign2;

import java.util.Random;

public class EncryptionTester {
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
    public static void testSet1(){

        //created an instance of Encryptor and
        // set the offset to the values given
        //Values that error out are commented out.
        //Encryptor encryptor1 = new Encryptor(0);
        Encryptor encryptor2 = new Encryptor(3);
        Encryptor encryptor3 = new Encryptor(11);
        Encryptor encryptor4 = new Encryptor(25);
//        Encryptor encryptor5 = new Encryptor(26);
        Encryptor[] encryptors = new Encryptor[3];
        encryptors[0] = encryptor2;
        encryptors[1] = encryptor3;
        encryptors[2] = encryptor4;
        printEncryptedAndDecrypted(encryptors);



    }
    public static void testSet2(){
        Encryptor[] encryptors = new Encryptor[4];
        for(int i = 0;i < 4;i++)
            encryptors[i] = new Encryptor((int)(1 + Math.floor(Math.random() * 24)));
        printEncryptedAndDecrypted(encryptors);
    }
    public static void main(String[] args) {

        System.out.println("testset 1");
        testSet1();
        System.out.println("testset 2");
        testSet2();
    }
}
