package org.example;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Provider[] providers = Security.getProviders();

        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            Cipher cipher2= Cipher.getInstance("AES/ECB/PKCS7PADDING");

            int a=0;
            //cipher.init(Cipher.ENCRYPT_MODE, certificate);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }  catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello World!");
    }



}
