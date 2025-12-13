
package com.mycompany.app;

import java.security.Security;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.util.Base64;

public class SimpleBouncyCastleAES {
    public static void main(String[] args) throws Exception {
        // add BC provider
        Security.addProvider(new BouncyCastleProvider());

        // generate a secret AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES", "BC");
        keyGen.init(128); // you could use 256 if unlimited strength policies allow
        Key secretKey = keyGen.generateKey();

        String plainText = "Hello, Bouncy Castle!";
        System.out.println("Plain text: " + plainText);

        // encrypt
        Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = encryptCipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        String cipherBase64 = Base64.getEncoder().encodeToString(cipherBytes);
        System.out.println("Cipher text (base64): " + cipherBase64);

        // decrypt
        Cipher decryptCipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(cipherBase64));
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);
        System.out.println("Decrypted text: " + decryptedText);
    }
}
