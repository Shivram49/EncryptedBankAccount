package assign2;

/**

 This interface defines the methods required for encryption and decryption of a text.
 */
public interface Encryptable {

    /**

     Encrypts the provided text.
     @param text The text to be encrypted.
     @return The encrypted text.
     */
    String encrypt(String text);
    /**

     Decrypts the provided text.
     @param text The text to be decrypted.
     @return The decrypted text.
     */
    String decrypt(String text);
}