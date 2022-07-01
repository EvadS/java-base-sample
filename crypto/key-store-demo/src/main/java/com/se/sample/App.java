package com.se.sample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import javax.xml.bind.DatatypeConverter;
import java.security.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        extracted();

        testProviders();
        System.out.println("-------------------------");
        testHashing();
    }

    /**
     * print available crypto provider
     */
    public static  void testProviders(){
        Provider[] providers = Security.getProviders();
        for (Provider p : providers) {
            System.out.println(p.getName());
        }
    }

    static void testHashing(){
        try {
            //криптографии дайджестом называется хэш-сумма
            MessageDigest digester = MessageDigest.getInstance("SHA-512");
            byte[] input = "Secret string".getBytes();
            byte[] digest = digester.digest(input);
            System.out.println(DatatypeConverter.printHexBinary(digest));


            byte[] salt = new byte[16];
            SecureRandom.getInstanceStrong().nextBytes(salt);
            digester.update(salt);
            digest =  digester.digest(input);

            System.out.println("with salt :");
            System.out.println(DatatypeConverter.printHexBinary(digest));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void extracted() {
        String code = "1СКЕУГЬГМХИФЯ Е УЛП";
        for (char symbol : code.toCharArray()) {
            if (symbol != ' ') {
                symbol = (char) (symbol - 3);
            }
            System.out.print(symbol);
        }
    }
}
