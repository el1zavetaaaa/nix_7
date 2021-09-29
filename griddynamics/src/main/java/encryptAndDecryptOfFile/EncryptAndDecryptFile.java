package encryptAndDecryptOfFile;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.Base64;

public class EncryptAndDecryptFile {

    private static final String IV = "AAACCCDDDYYUURRS";

    public static void start() {
        try {
            test_encrypt_decrypt();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    public static String encrypt(String key, String iv, String msg) throws Exception {
        byte[] bytesOfKey = key.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] keyBytes = md.digest(bytesOfKey);

        final byte[] ivBytes = iv.getBytes();

        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(ivBytes));

        final byte[] resultBytes = cipher.doFinal(msg.getBytes());
        return Base64.getMimeEncoder().encodeToString(resultBytes);
    }

    public static String decrypt(String key, String iv, String encrypted) throws Exception {
        byte[] bytesOfKey = key.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] keyBytes = md.digest(bytesOfKey);

        final byte[] ivBytes = iv.getBytes();

        final byte[] encryptedBytes = Base64.getMimeDecoder().decode(encrypted);

        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(ivBytes));

        final byte[] resultBytes = cipher.doFinal(encryptedBytes);
        return new String(resultBytes);
    }

    public static String readFile(String filename) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        } finally {
            br.close();
        }
    }


    public static void test_encrypt_decrypt() throws Exception {
        String s = readFile("griddynamics/src/main/resources/randomNumbers.txt");
        String res = encrypt("mykey", IV, s);
        PrintWriter writer = new PrintWriter("griddynamics/src/main/resources/encryptFile.txt", "UTF-8");
        System.out.println("Encrypt text from file randomNumbers.txt: " + res + "\n");
        writer.print(res);
        writer.close();
        // decrypt "encryptFile.txt" -> "DecryptFile.txt"
        s = readFile("griddynamics/src/main/resources/encryptFile.txt");
        res = decrypt("mykey", IV, s);
        writer = new PrintWriter("griddynamics/src/main/resources/DecryptFile.txt", "UTF-8");
        System.out.println("Decrypt text from file randomNumbers.txt: " + res + "\n");
        writer.print(res);
        writer.close();
    }


}
