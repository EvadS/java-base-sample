package com.se.sample;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class KeyToolDemo {

    private static final  String CERT_PATH = "/home/softkit/Documents/keystore";
    public static void main(String[] args) throws KeyStoreException {
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

        KeyStore keyStore = getKeyStore();

        KeyManager[] keyManagers = getKeyManagers(keyStore);
        int a =0;
    }

    public static KeyStore getKeyStore() {
        // Согласно https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyStore
        try(FileInputStream fis = new FileInputStream(CERT_PATH+ "/keystore.jks")){
            System.out.println("path: "+ CERT_PATH+ "/keystore.jks");
            KeyStore keyStore = KeyStore.getInstance("pkcs12");
            keyStore.load(fis, "123456".toCharArray());
            return keyStore;
        } catch (IOException ioe) {
            throw new IllegalStateException(ioe);
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            throw new IllegalStateException(e);
        }
    }

    public static KeyManager[] getKeyManagers(KeyStore keyStore) {
        String keyManagerAlgo = KeyManagerFactory.getDefaultAlgorithm();
        KeyManagerFactory keyManagerFactory = null;
        try {
            keyManagerFactory = KeyManagerFactory.getInstance(keyManagerAlgo);
            keyManagerFactory.init(keyStore, "123456".toCharArray());
            return keyManagerFactory.getKeyManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        } catch (UnrecoverableKeyException | KeyStoreException e) {
            throw new IllegalStateException(e);
        }
    }
}
