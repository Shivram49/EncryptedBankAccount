package assign2;

public class Main {

    public static void main(String[] args) {
        Encryptor encryptor = new Encryptor(26);
        System.out.println(encryptor.encrypt("ABCDEFGHIJ33KLMNOPQRSTUVWXYZ123"));
        System.out.println(encryptor.decrypt(encryptor.encrypt("ABCDEFGHIJ33KLMNOPQRSTUVWXYZ123")));
    }
}
