package assign2;

import java.util.Locale;

public class Encryptor implements Encryptable{
    private int offset;
    //The offset should be greater than 0 and less than 26.
    // It should be initialized in the constructors.
    public Encryptor(int offset) {
        if(offset <= 0 || offset >= 26) {
            System.err.println("Please enter a number in the range 0 - 26 non inclusive");
            throw new IllegalArgumentException();
        }
        this.offset = offset;
    }

    public void setOffset(int shift){
        this.offset = shift;
    }

    public int getOffset() {
        return offset;
    }

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
