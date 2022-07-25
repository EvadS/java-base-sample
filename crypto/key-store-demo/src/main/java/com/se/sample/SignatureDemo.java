package com.se.sample;
import javax.crypto.*;
import java.security.*;

public class SignatureDemo {


    public static void main(String[] args)  {
        try {
            testSignature("Hello");
            System.out.println("completed ");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * используется пара ключей: private key (хранится от всех в секрете) и public key (доступен публично)
     */
    static void testSignature(String inputString) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, SignatureException {
        // Generate keys: В создании пары ключей нам нам нужен KeyPairGenerator.
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        SecureRandom random = SecureRandom.getInstanceStrong();
        generator.initialize(2048, random);
        KeyPair keyPair = generator.generateKeyPair();

        // Digital Signature
        Signature digitalSignature = Signature.getInstance("SHA256withRSA");
        digitalSignature.initSign(keyPair.getPrivate());

        // Update and sign the data подписать public key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] data = cipher.doFinal(inputString.getBytes());
        digitalSignature.update(data);
        byte[] signature = digitalSignature.sign();

        // Verify signature
        digitalSignature.initVerify(keyPair.getPublic());
        digitalSignature.update(data);
        boolean verifies = digitalSignature.verify(signature);
        System.out.println("Signature is ok: " + verifies);

        // Decrypt if signature is correct
        if (verifies) {
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
            byte[] result = cipher.doFinal(data);
            System.out.println(new String(result));
        }
    }
}
