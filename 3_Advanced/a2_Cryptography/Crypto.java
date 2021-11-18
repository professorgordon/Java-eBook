/*
 * Crypto.java - Class containing encryption / decryption features
 *               using the Java API and the Apache Commons library.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedcryptography.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 * 
 * Note: In order to run this code you need to download the
 * POI library from https://poi.apache.org/download.html. Then
 * unzip the downloaded file and then follow these steps:
 * 		* Right-click your project
 * 		* Select Build Path
 * 		* Configure Build Path
 * 		* Libraries
 * 		* Class Path
 * 		* Add External JARS
 * 		* Navigate to the downloaded POI location and open the 
 * 		  lib subdirectory
 * 		* Select all the .JAR files there
 * 		* Click Apply & Close
 */

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Crypto
{
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;

    public Crypto() throws Exception 
    {
        myEncryptionKey = "LordOfTheRingsFrodoBilbo";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }

    public String encrypt(String unencryptedString) 
    {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

    public String decrypt(String encryptedString) 
    {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString.getBytes());
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }

}