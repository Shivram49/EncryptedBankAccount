package assign2;

/**

 The EncryptionFactory class provides a factory method for creating different types of encryptors based on the chosen algorithm.
 The available algorithms are Ceasar and RSA.
 */
public class EncryptionFactory {
    /**
     * Returns an instance of the Encryptable interface, based on the chosen encryption algorithm.
     *
     * @param algorithm the chosen algorithm for encryption
     * @return an instance of the Encryptable interface for the chosen algorithm
     */
    public static Encryptable createEncryptor(String algorithm){
        switch (algorithm){
            case "Ceasar": return new Encryptor();
            case "RSA": return new RSAEncryptor();
            default:return new Encryptor();
        }
    }
}
