
package assign2;

import java.util.Locale;


/**

 This class provides encryption and decryption of text using a Caesar Cipher.
 The encryption and decryption are done by shifting the characters by a fixed number of positions.
 The class implements the Encryptable interface.
 */

public class Encryptor implements Encryptable{
    /**
     * The offset is the number of positions by which the characters are shifted during encryption and decryption.
     * It should be greater than 0 and less than 26.
     * It should be initialized in the constructors.
     */
    private int offset;
    /**
     * Creates an Encryptor object with the default offset of 1.
     */
    public Encryptor() {
        this.offset = 10;
    }

    /**
     * Sets the offset for encryption and decryption.
     * The offset should be greater than 0 and less than 26.
     * If an invalid offset is entered, a default offset of 10 is set.
     * @param shift the number of positions by which to shift the characters
     */
    public void setOffset(int shift){
        if(shift <= 0 || shift >= 26) {
            System.out.println("Offset : " + shift + " invalid, Please enter a number in the range 0 - 26 non inclusive");
            this.offset = 10;
        }
        else
            this.offset = shift;
    }

    /**
     * Returns the current offset for encryption and decryption.
     * @return the current offset
     */
    public int getOffset() {
        return offset;
    }


    /**
     * Encrypts a text by shifting the characters by the offset.
     * Only alphabetic characters are shifted, non-alphabetic characters are ignored.
     * The text is converted to uppercase before encryption.
     * @param text the text to be encrypted
     * @return the encrypted text
     */
    @Override
    public String encrypt(String text) {
        text = text.toUpperCase();
        char[] textArray = text.toCharArray();
        for(int i = 0;i < textArray.length;i++){
            if(Character.isAlphabetic(textArray[i]))
                textArray[i] = (char)((textArray[i] - 'A'+this.offset)%26 + 'A');
        }
        return  new String(textArray);
    }



    /**
     * Decrypts a text by shifting the characters in the opposite direction of the offset.
     * Only alphabetic characters are shifted, non-alphabetic characters are ignored.
     * @param text the text to be decrypted
     * @return the decrypted text
     */
    @Override
    public String decrypt(String text) {
        char[] textArray = text.toCharArray();
        for(int i = 0;i < textArray.length;i++){
            if(Character.isAlphabetic(textArray[i]))
                textArray[i] = (char)((textArray[i] - 'A'+(26 - this.offset))%26 + 'A');
        }
        return  new String(textArray);
    }
}
