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

    //BASE
  //  private static final  String CERT_PATH = "/home/softkit/Documents/keystore";
  //  public static final String KEYSTORE_JKS = "/keystore.jks";
  // public static final String PWD = "123456";

      private static final  String CERT_PATH = "/home/softkit/Documents/certification-manager/trustore/fdf42355-e86f-4c5d-8b5b-facae0ff3cd0";
     public static final String KEYSTORE_JKS = "/latest";
    public static final String PWD = "mypassword";

    public static void main(String[] args) throws KeyStoreException {
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

        KeyStore keyStore = getKeyStore();

        KeyManager[] keyManagers = getKeyManagers(keyStore);
        int a =0;
    }

    public static KeyStore getKeyStore() {
        // Согласно https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyStore
        try(FileInputStream fis = new FileInputStream(CERT_PATH+ KEYSTORE_JKS)){
            System.out.println("path: "+ CERT_PATH+ KEYSTORE_JKS);
            KeyStore keyStore = KeyStore.getInstance("pkcs12");
            keyStore.load(fis, PWD.toCharArray());
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
            keyManagerFactory.init(keyStore, PWD.toCharArray());
            return keyManagerFactory.getKeyManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        } catch (UnrecoverableKeyException | KeyStoreException e) {
            throw new IllegalStateException(e);
        }
    }
}
