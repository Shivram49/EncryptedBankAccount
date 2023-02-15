package assign2;

public class EncryptionTester {
    public static void testSet1(){

        //created an instance of Encryptor and
        // set the offset to the values given
        //Values that error out are commented out.
        //Encryptor encryptor1 = new Encryptor(0);
        Encryptor encryptor2 = new Encryptor(3);
        Encryptor encryptor3 = new Encryptor(11);
        Encryptor encryptor4 = new Encryptor(25);
//        Encryptor encryptor5 = new Encryptor(26);
        Encryptor[] encryptorArray = new Encryptor[3];
        encryptorArray[0] = encryptor2;
        encryptorArray[1] = encryptor3;
        encryptorArray[2] = encryptor4;

        for(Encryptor encryptor : encryptorArray) {
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

    public static void main(String[] args) {

        testSet1();
    }
}
